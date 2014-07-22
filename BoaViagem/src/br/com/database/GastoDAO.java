package br.com.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.database.domain.EnCategoriaGasto;
import br.com.database.domain.Gasto;
import br.com.database.domain.Viagem;

public class GastoDAO {

	public static String ID_VIAGEM = "viagemid";
	public static String ID = "id";
	public static String CATEGORIA = "categoria";
	public static String DATA = "data";
	public static String VALOR = "valor";
	public static String DESCRICAO = "descricao";
	public static String LOCAL = "local";
	public static String TABELA = "gasto";
	public static String[] COLUNAS = new String[] { ID_VIAGEM, ID, CATEGORIA, DATA, VALOR, DESCRICAO, LOCAL };

	private final Database database;
	private static GastoDAO gastoDAO;

	private static final String BUSCA_GASTO;
	private static final String BUSCA_GASTOS_ID_VIAGEM;
	private static final String BUSCA_TOTAL_GASTOS_VIAGEM;
	private static final String BUSCA_ULTIMO_ID;

	static {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		for (String coluna : COLUNAS) {
			builder.append(coluna);
			builder.append(", ");
		}
		builder.replace(builder.lastIndexOf(", "), builder.length(), " FROM ");
		builder.append(TABELA);
		builder.append(" WHERE ");
		builder.append(ID_VIAGEM);
		builder.append(" = ?");
		BUSCA_GASTOS_ID_VIAGEM = builder.toString();

		builder = new StringBuilder();
		builder.append("SELECT ");
		for (String coluna : COLUNAS) {
			builder.append(coluna);
			builder.append(", ");
		}
		builder.replace(builder.lastIndexOf(", "), builder.length(), " FROM ");
		builder.append(TABELA);
		builder.append(" WHERE ");
		builder.append(ID_VIAGEM);
		builder.append(" = ? AND ");
		builder.append(ID);
		builder.append(" = ?");
		BUSCA_GASTO = builder.toString();

		builder = new StringBuilder();
		builder.append("SELECT SUM(");
		builder.append(VALOR);
		builder.append(") FROM ");
		builder.append(TABELA);
		builder.append(" WHERE ");
		builder.append(ID_VIAGEM);
		builder.append(" = ?");
		BUSCA_TOTAL_GASTOS_VIAGEM = builder.toString();

		builder = new StringBuilder();
		builder.append("SELECT MAX(");
		builder.append(ID);
		builder.append(") FROM ");
		builder.append(TABELA);
		builder.append(" WHERE ");
		builder.append(ID_VIAGEM);
		builder.append(" = ?");
		BUSCA_ULTIMO_ID = builder.toString();
	}

	private GastoDAO(Context context) {
		database = new Database(context);
	}

	public static GastoDAO getInstance(Context context) {
		if (gastoDAO == null) {
			gastoDAO = new GastoDAO(context);
		}
		return gastoDAO;
	}

	public static void create(SQLiteDatabase db) {
		StringBuilder builder = new StringBuilder();
		builder.append("CREATE TABLE ");
		builder.append(TABELA);
		builder.append(" (");
		builder.append(ID_VIAGEM);
		builder.append(" INTEGER NOT NULL, ");
		builder.append(ID);
		builder.append(" INTEGER NOT NULL, ");
		builder.append(CATEGORIA);
		builder.append(" INTEGER, ");
		builder.append(DATA);
		builder.append(" DATE, ");
		builder.append(VALOR);
		builder.append(" DOUBLE, ");
		builder.append(DESCRICAO);
		builder.append(" TEXT, ");
		builder.append(LOCAL);
		builder.append(" TEXT, PRIMARY KEY (");
		builder.append(ID_VIAGEM);
		builder.append(", ");
		builder.append(ID);
		builder.append("), ");
		builder.append("FOREIGN KEY (");
		builder.append(ID_VIAGEM);
		builder.append(") REFERENCES viagem(");
		builder.append(Viagem.ID);
		builder.append("));");

		db.execSQL(builder.toString());
	}

	public static void destroy(SQLiteDatabase db) {
		StringBuilder builder = new StringBuilder();
		builder.append("DROP TABLE ");
		builder.append(TABELA);

		db.execSQL(builder.toString());
	}

	public int getUltimoID(int viagemid) {
		int ultimoID = 1;
		SQLiteDatabase sql = database.getReadableDatabase();
		Cursor cursor = sql.rawQuery(BUSCA_ULTIMO_ID, new String[] { String.valueOf(viagemid) });
		try {
			if (cursor.moveToFirst()) {
				ultimoID = cursor.getInt(0);
			}
		} finally {
			cursor.close();
		}
		return ultimoID;
	}

	public List<Gasto> getGastosPorViagem(int viagemid) {
		List<Gasto> gastos = new ArrayList<Gasto>();

		SQLiteDatabase sql = database.getReadableDatabase();
		Cursor cursor = sql.rawQuery(BUSCA_GASTOS_ID_VIAGEM, new String[] { String.valueOf(viagemid) });
		try {
			for (int i = 0; i < cursor.getCount(); i++) {
				cursor.moveToNext();

				int idViagem = cursor.getInt(0);
				int id = cursor.getInt(1);
				int categoria = cursor.getInt(2);
				Date data = new Date(cursor.getLong(3));
				double valor = cursor.getDouble(4);
				String descricao = cursor.getString(5);
				String local = cursor.getString(6);

				Gasto gasto = new Gasto(idViagem, id, EnCategoriaGasto.get(categoria), data, valor, descricao, local);
				gastos.add(gasto);
			}

		} finally {
			cursor.close();
		}

		return gastos;
	}

	public Gasto getGasto(int viagemId, int idGasto) {
		Gasto gasto = null;

		SQLiteDatabase sql = database.getReadableDatabase();
		Cursor cursor = sql.rawQuery(BUSCA_GASTO, new String[] { String.valueOf(viagemId), String.valueOf(idGasto) });
		try {
			if (cursor.moveToFirst()) {
				int idViagem = cursor.getInt(0);
				int id = cursor.getInt(1);
				int categoria = cursor.getInt(2);
				Date data = new Date(cursor.getLong(3));
				double valor = cursor.getDouble(4);
				String descricao = cursor.getString(5);
				String local = cursor.getString(6);

				gasto = new Gasto();
				gasto.setIdViagem(idViagem);
				gasto.setId(id);
				gasto.setCategoria(EnCategoriaGasto.get(categoria));
				gasto.setData(data);
				gasto.setValor(valor);
				gasto.setDescricao(descricao);
				gasto.setLocal(local);
			}
		} finally {
			cursor.close();
		}

		return gasto;
	}

	public double getTotalGastosPorViagem(int viagemid) {
		SQLiteDatabase sql = database.getReadableDatabase();
		Cursor cursor = sql.rawQuery(BUSCA_TOTAL_GASTOS_VIAGEM, new String[] { String.valueOf(viagemid) });
		try {
			cursor.moveToFirst();
			double valor = cursor.getDouble(0);
			return valor;
		} finally {
			cursor.close();
		}
	}

	public boolean inserir(Gasto gasto) {
		ContentValues values = getContenValues(gasto);

		SQLiteDatabase sql = database.getWritableDatabase();
		try {
			long insert = sql.insert(TABELA, null, values);
			return insert != -1;
		} finally {
			sql.close();
		}
	}

	public boolean atualizar(Gasto gasto) {
		ContentValues values = getContenValues(gasto);

		SQLiteDatabase sql = database.getWritableDatabase();
		try {
			int update = sql.update(TABELA, values, ID_VIAGEM + " = ? and " + ID + " = ? ", new String[] { String.valueOf(gasto.getIdViagem()), String.valueOf(gasto.getId()) });
			return update > 0;
		} finally {
			sql.close();
		}
	}

	public boolean apagarGastosPorViagem(int viagemid) {
		SQLiteDatabase sql = database.getWritableDatabase();
		int delete = sql.delete(TABELA, ID_VIAGEM + " = ?", new String[] { String.valueOf(viagemid) });
		return delete > 0;
	}

	public boolean apagar(int viagemid, int id) {
		SQLiteDatabase sql = database.getWritableDatabase();
		int delete = sql.delete(TABELA, ID_VIAGEM + " = ? and " + ID + " = ? ", new String[] { String.valueOf(viagemid), String.valueOf(id) });
		return delete > 0;
	}

	private static ContentValues getContenValues(Gasto gasto) {
		ContentValues values = new ContentValues();
		values.put(ID_VIAGEM, gasto.getIdViagem());
		values.put(ID, gasto.getId());
		values.put(CATEGORIA, gasto.getCategoria().getId());
		values.put(DATA, gasto.getData().getTime());
		values.put(VALOR, gasto.getValor());
		values.put(DESCRICAO, gasto.getDescricao());
		values.put(LOCAL, gasto.getLocal());
		return values;
	}
}

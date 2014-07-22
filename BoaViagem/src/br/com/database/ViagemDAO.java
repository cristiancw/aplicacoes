package br.com.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.database.domain.EnTipoViagem;
import br.com.database.domain.Viagem;

public class ViagemDAO {

	public static String ID = "id";
	public static String DESTINO = "destino";
	public static String TIPO = "tipo";
	public static String DATA_CHEGADA = "datachegada";
	public static String DATA_SAIDA = "datasaida";
	public static String ORCAMENTO = "orcamento";
	public static String QTD_PESSOAS = "qtdpessoas";
	public static String TABELA = "viagem";
	public static String[] COLUNAS = new String[] { ID, DESTINO, TIPO, DATA_CHEGADA, DATA_CHEGADA, ORCAMENTO, QTD_PESSOAS };

	private final Context context;
	private final Database database;
	private static ViagemDAO viagemDAO;

	private static final String BUSCA_TODAS_VIAGENS;
	private static final String BUSCA_VIAGEM;
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
		BUSCA_TODAS_VIAGENS = builder.toString();

		builder = new StringBuilder();
		builder.append("SELECT ");
		for (String coluna : COLUNAS) {
			builder.append(coluna);
			builder.append(", ");
		}
		builder.replace(builder.lastIndexOf(", "), builder.length(), " FROM ");
		builder.append(TABELA);
		builder.append(" WHERE ");
		builder.append(ID);
		builder.append(" = ?");
		BUSCA_VIAGEM = builder.toString();

		builder = new StringBuilder();
		builder.append("SELECT MAX(");
		builder.append(ID);
		builder.append(") FROM ");
		builder.append(TABELA);
		BUSCA_ULTIMO_ID = builder.toString();
	}

	private ViagemDAO(Context context) {
		this.context = context;
		database = new Database(context);
	}

	public static ViagemDAO getInstance(Context context) {
		if (viagemDAO == null) {
			viagemDAO = new ViagemDAO(context);
		}
		return viagemDAO;
	}

	public static void create(SQLiteDatabase db) {
		StringBuilder builder = new StringBuilder();
		builder.append("CREATE TABLE ");
		builder.append(TABELA);
		builder.append(" (");
		builder.append(ID);
		builder.append(" INTEGER NOT NULL PRIMARY KEY, ");
		builder.append(DESTINO);
		builder.append(" TEXT, ");
		builder.append(TIPO);
		builder.append(" INTEGER, ");
		builder.append(DATA_CHEGADA);
		builder.append(" DATE, ");
		builder.append(DATA_SAIDA);
		builder.append(" DATE, ");
		builder.append(ORCAMENTO);
		builder.append(" DOUBLE, ");
		builder.append(QTD_PESSOAS);
		builder.append(" INTEGER);");

		db.execSQL(builder.toString());
	}

	public static void destroy(SQLiteDatabase db) {
		StringBuilder builder = new StringBuilder();
		builder.append("DROP TABLE ");
		builder.append(TABELA);

		db.execSQL(builder.toString());
	}

	public int getUltimoID() {
		int ultimoID = 0;
		SQLiteDatabase sql = database.getReadableDatabase();
		Cursor cursor = sql.rawQuery(BUSCA_ULTIMO_ID, null);
		try {
			if (cursor.moveToFirst()) {
				ultimoID = cursor.getInt(0);
			}
		} finally {
			cursor.close();
		}
		return ultimoID;
	}

	public List<Viagem> getViagens() {
		List<Viagem> viagens = new ArrayList<Viagem>();

		SQLiteDatabase sql = database.getReadableDatabase();
		Cursor cursor = sql.rawQuery(BUSCA_TODAS_VIAGENS, null);
		try {
			for (int i = 0; i < cursor.getCount(); i++) {
				cursor.moveToNext();

				int id = cursor.getInt(0);
				String destino = cursor.getString(1);
				int tipo = cursor.getInt(2);
				EnTipoViagem tipoViagem = EnTipoViagem.get(tipo);
				Date dataChegada = new Date(cursor.getLong(3));
				Date dataSaida = new Date(cursor.getInt(4));
				double orcamento = cursor.getDouble(5);
				int qtdPessoas = cursor.getInt(6);

				Viagem viagem = new Viagem(id, destino, tipoViagem, dataChegada, dataSaida, orcamento, qtdPessoas);
				viagens.add(viagem);
			}
		} finally {
			cursor.close();
		}

		return viagens;
	}

	public Viagem getViagem(int viagemId) {
		Viagem viagem = null;

		SQLiteDatabase sql = database.getReadableDatabase();
		Cursor cursor = sql.rawQuery(BUSCA_VIAGEM, new String[] { String.valueOf(viagemId) });
		try {
			if (cursor.moveToFirst()) {
				int id = cursor.getInt(0);
				String destino = cursor.getString(1);
				int tipo = cursor.getInt(2);
				EnTipoViagem tipoViagem = EnTipoViagem.get(tipo);
				Date dataChegada = new Date(cursor.getLong(3));
				Date dataSaida = new Date(cursor.getInt(4));
				double orcamento = cursor.getDouble(5);
				int qtdPessoas = cursor.getInt(6);

				viagem = new Viagem();
				viagem.setId(id);
				viagem.setDestino(destino);
				viagem.setTipo(tipoViagem);
				viagem.setDataChegada(dataChegada);
				viagem.setDataSaida(dataSaida);
				viagem.setOrcamento(orcamento);
				viagem.setQtdPessoas(qtdPessoas);
			}
		} finally {
			cursor.close();
		}

		return viagem;
	}

	public boolean inserir(Viagem viagem) {
		ContentValues values = getContenValues(viagem);

		SQLiteDatabase sql = database.getWritableDatabase();
		try {
			long insert = sql.insert(TABELA, null, values);
			return insert != -1;
		} finally {
			sql.close();
		}
	}

	public boolean atualizar(Viagem viagem) {
		ContentValues values = getContenValues(viagem);

		SQLiteDatabase sql = database.getWritableDatabase();
		try {
			int update = sql.update(TABELA, values, ID + " = ?", new String[] { String.valueOf(viagem.getId()) });
			return update > 0;
		} finally {
			sql.close();
		}
	}

	public boolean apagar(int viagemid) {
		boolean okay = false;
		SQLiteDatabase sql = database.getWritableDatabase();

		// sql.beginTransaction();
		try {
			boolean removeu = GastoDAO.getInstance(context).apagarGastosPorViagem(viagemid);
			int delete = sql.delete(TABELA, ID + " = ?", new String[] { String.valueOf(viagemid) });
			okay = delete > 0 && removeu;
			// sql.setTransactionSuccessful();
		} finally {
			// sql.endTransaction();
			sql.close();
		}
		return okay;
	}

	private static ContentValues getContenValues(Viagem viagem) {
		ContentValues values = new ContentValues();
		values.put(ID, viagem.getId());
		values.put(DESTINO, viagem.getDestino());
		values.put(TIPO, viagem.getTipo().getId());
		values.put(DATA_CHEGADA, viagem.getDataChegada().getTime());
		values.put(DATA_CHEGADA, viagem.getDataSaida().getTime());
		values.put(ORCAMENTO, viagem.getOrcamento());
		values.put(QTD_PESSOAS, viagem.getOrcamento());
		return values;
	}
}

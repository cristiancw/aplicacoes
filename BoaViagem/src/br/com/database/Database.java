package br.com.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class Database extends SQLiteOpenHelper {

	private static String NOME_BASE = "boaViagem";
	private static int VERSAO = 2;

	Database(Context context) {
		super(context, NOME_BASE, null, VERSAO);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		ViagemDAO.create(db);
		GastoDAO.create(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVerdion, int newVersion) {
		if (oldVerdion == 1) {
			GastoDAO.destroy(db);
			ViagemDAO.destroy(db);
		}
		onCreate(db);
	}
}

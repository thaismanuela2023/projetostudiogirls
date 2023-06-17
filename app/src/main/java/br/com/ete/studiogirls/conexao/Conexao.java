package br.com.ete.studiogirls.conexao;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import br.com.ete.studiogirls.model.Servico;

public class Conexao  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "banco.db";
    private static final int DATABASE_VERSION = 1;

    public Conexao(Context ctx) {
        super(ctx, DATABASE_NAME, null,
                DATABASE_VERSION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {

            db.execSQL("CREATE TABLE cliente (" +
                    "id INTEGER PRIMARY KEY autoincrement, " +
                    "nome VARCHAR(100), " +
                    "telefone VARCHAR(15), " +
                    "endereco VARCHAR(100));");

            db.execSQL("CREATE TABLE agendamento (" +
                    "id INTEGER PRIMARY KEY autoincrement, " +
                    "data DATETIME, " +
                    "cliente VARCHAR(100), " +
                    "servicos VARCHAR(50));");


            db.execSQL("CREATE TABLE profissionais (" +
                    "id INTEGER PRIMARY KEY autoincrement, " +
                    "nome VARCHAR(200));");


        } catch (SQLException ex) {
            Log.e("STUDIO", ex.getMessage());
        }
    }



}


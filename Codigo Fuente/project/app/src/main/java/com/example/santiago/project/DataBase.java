package com.example.santiago.project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Santiago on 08/11/2016.
 */

public class DataBase extends SQLiteOpenHelper {

    String query1 = "CREATE TABLE PARAMETROS(ID INTEGER, VALOR TEXT, DESCRIPCIION TEXT)";
    String query2 = "INSERT INTO PARAMETROS (ID, VALOR, DESCRIPCIION) VALUES (1, '0','CONTROL INGRESO EN LA APLICACION')";
    String query3 = "INSERT INTO PARAMETROS (ID, VALOR, DESCRIPCIION) VALUES (2, '0','SELECCION DE MOTO')";

    public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

package com.example.karan.databases2.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.karan.databases2.db.tables.Todos;

/**
 * Created by Karan on 05-02-2017.
 */

public class TodoDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "Todos.db";
    public static final int DB_VER = 2;

    public TodoDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Todos.CMD_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public interface Consts {
        String LBR = " ( ";
        String RBR = " ) ";
        String COMMA = " , ";
        String SEMICOL = " ; ";
        String TYPE_INT = " INTEGER ";
        String TYPE_TEXT = " TEXT ";
        String TYPE_PK = "PRIMARY KEY ";
        String TYPE_AI = "AUTOINCREMENT";
        String TYPE_BOOLEAN = " BOOLEAN ";
    }
}

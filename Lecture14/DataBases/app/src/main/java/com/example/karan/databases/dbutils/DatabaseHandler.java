package com.example.karan.databases.dbutils;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.karan.databases.tables.Courses;

/**
 * Created by Karan on 29-01-2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String DB_NAME = "MyDatabase.db";
    public static final int DB_VER = 1;


    /**
     * This database is created in data/data/package name/db
     * schema-definitions all entries in a table
     * the existing schema has changed-for ex:the column has been added so we need to add the data to all rows for all entries as well
     * the changes made in data base will be known by the data base version
     * Now we need only to pass the context
     * to update version we need witch cases
     * if the database schema's changes ie . the design of the app changes
     * if the version increment is more than one then onUpgrade will run for the difference in the current version and now latest version
     * the number of tables==number of classes is necessary
     * because relational calculus will be possible
     */
    public DatabaseHandler(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Courses.CMD_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

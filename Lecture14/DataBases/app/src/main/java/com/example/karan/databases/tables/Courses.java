package com.example.karan.databases.tables;

/**
 * Created by Karan on 29-01-2017.
 */

import android.database.sqlite.SQLiteDatabase;

import static com.example.karan.databases.dbutils.Consts.*;

public class Courses {
    public static final String TABLE_NAME = "courses";
    public static final String COL_ID = "course_id";
    public static final String COL_NAME = "course_name";
    public static final String COL_FEES = "course_fees";
    public static final String CMD_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + LBR + COL_ID + TYPE_INT + TYPE_PK + COL_NAME + TYPE_TEXT + RBR + SEMCOL;

    public static void createCourse(String courseName, int fees, SQLiteDatabase db) {

    }
}

package com.example.karan.todolist.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.karan.todolist.models.Todos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.example.karan.todolist.TodoDBHelper.Consts.*;

/**
 * Created by Karan on 14-02-2017.
 */

public class Todo {
    public static final String TABLE_NAME = "todos";
    public static final String CMD_TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + LBR + Columns.ID + TYPE_INT + TYPE_PK + TYPE_AI + COMMA + Columns.TASK + TYPE_TEXT + COMMA + Columns.DATE + TYPE_TEXT + RBR + SEMICOL;

    public static boolean addTask(String task, SQLiteDatabase db, String date) {
        if (db.isReadOnly()) {
            return false;
        }
        ContentValues taskObj = new ContentValues();
        taskObj.put(Columns.TASK, task);
        taskObj.put(Columns.DATE, date);
        db.insert(TABLE_NAME, null, taskObj);
        return true;
    }

    public static ArrayList<Todos> getAllTasks(SQLiteDatabase db) {
        String[] PROJECTION = {
                Columns.ID, Columns.TASK, Columns.DATE
        };
        Cursor cur = db.query(TABLE_NAME, PROJECTION, null, null, null, null, null);
        cur.moveToFirst();
        int id = cur.getColumnIndex(Columns.ID);
        int taskIndex = cur.getColumnIndex(Columns.TASK);
        int dateIndex = cur.getColumnIndex(Columns.DATE);
        ArrayList<Todos> todos = new ArrayList<>();
        while (cur.moveToNext()) {
            todos.add(new Todos(cur.getString(taskIndex), cur.getInt(id), cur.getString(dateIndex)));
        }
        return todos;
    }

    public interface Columns {
        String ID = "todo_id";
        String TASK = "todo_task";
        String DATE = "todo_date";
    }
}


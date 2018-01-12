package com.example.karan.databases2.db.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.karan.databases2.db.TodoDBHelper;
import com.example.karan.databases2.models.Todo;

import java.util.ArrayList;

import static com.example.karan.databases2.db.TodoDBHelper.Consts.*;

/**
 * Created by Karan on 05-02-2017.
 */

public class Todos {
    public static final String TABLE_NAME = "todos";
    public static final String CMD_TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + LBR + Columns.ID + TYPE_INT + TYPE_PK + TYPE_AI + COMMA + Columns.TASK + TYPE_TEXT + RBR + SEMICOL;
    public static final String CMD_UPDATE_1_2_ADD_COL = "ALTER TABLE" + TABLE_NAME + " ADD " + Columns.DONE + TYPE_BOOLEAN + SEMICOL;

    public static boolean addTask(String task, SQLiteDatabase db) {
        if (db.isReadOnly()) {
            return false;
        }
        ContentValues taskObj = new ContentValues();
        taskObj.put(Columns.TASK, task);
        //null-column-hack(useful in file based databases) user can insert non null rows if not set non null-these type of rows make sorting searching slower,
        // therefore it inserts another column having a value null thereby making searching and sorting faster than before
        //if the row is totally empty it will set it to null in a hidden column
        //SQL-injection--if SQL query is written n form a string, if we inject another SQL- command after a semicolon then it will treat them as two seperate commands
        // and will execute them both so we have to avoid them
        db.insert(TABLE_NAME, null, taskObj);
        return true;
    }

    public static boolean updateTaskasDone(int taskId, SQLiteDatabase db) {
        if (db.isReadOnly()) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.TASK, "changed task");
        db.update(TABLE_NAME, contentValues, Columns.TASK + " = ?", new String[]{String.valueOf(taskId)});
        return true;
    }

    public static boolean deleteTask(String task, SQLiteDatabase db) {
        if (db.isReadOnly()) {
            return false;
        }
        String selection = Columns.TASK + " = ?";
        String[] SELECTION = {task};
        db.delete(TABLE_NAME, selection, SELECTION);
        return true;
    }

    //boolean distinct-if distinct entries are to be selected
    //cancellation signal- if a query loading takes time it can be cancelled midway
    public static ArrayList<Todo> getAllTasks(SQLiteDatabase db) {
        String[] PROJECTION = {
                Columns.ID, Columns.TASK
        };
        Cursor cur = db.query(TABLE_NAME, PROJECTION, null, null, null, null, null);
        cur.moveToFirst();
        int id = cur.getColumnIndex(Columns.ID);
        int taskIndex = cur.getColumnIndex(Columns.TASK);
        ArrayList<Todo> todos = new ArrayList<>();
        //moves the cursor to the next row and if it can be moved to the next it returns false
        while (cur.moveToNext()) {
            todos.add(new Todo(cur.getString(taskIndex), cur.getInt(id)));
        }
        return todos;
    }

    public interface Columns {
        String ID = "todo_id";
        String TASK = "todo_task";
        String DONE = "todo_done";
    }
}

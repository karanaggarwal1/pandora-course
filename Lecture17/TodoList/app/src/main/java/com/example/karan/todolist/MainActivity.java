package com.example.karan.todolist;

import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.karan.todolist.models.Todos;
import com.example.karan.todolist.tables.Todo;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TodoDBHelper dbHelper;
    TodoListAdapter todoListAdapter;
    Button btnAdd;
    EditText etNewTodo;
    RecyclerView todoList;
    ArrayList<Todos> todos=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new TodoDBHelper(this);
        todos = Todo.getAllTasks(dbHelper.getReadableDatabase());
        btnAdd = (Button) findViewById(R.id.btn_add_todo);
        etNewTodo = (EditText) findViewById(R.id.et_todo);
        todoList = (RecyclerView) findViewById(R.id.lv_todos);
        todoListAdapter = new TodoListAdapter(todos, this);
        todoList.setLayoutManager(new LinearLayoutManager(this));
        todoList.setAdapter(todoListAdapter);
        refreshTodos();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Todo.addTask(etNewTodo.getText().toString(), dbHelper.getWritableDatabase(), DateFormat.getDateTimeInstance().format(new Date()));
                refreshTodos();
            }
        });
    }

    void refreshTodos() {
        todos = Todo.getAllTasks(dbHelper.getReadableDatabase());
        todoListAdapter.upDateTodos(todos);
    }
}


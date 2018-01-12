package com.example.karan.databases2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.karan.databases2.db.TodoDBHelper;
import com.example.karan.databases2.db.tables.Todos;
import com.example.karan.databases2.models.Todo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TodoDBHelper dbHelper;
    TodoRecyclerViewAdapter todoRecyclerViewAdapter;
    Button btnAdd;
    EditText etNewTodo;
    RecyclerView todoList;
    ArrayList<Todo> todos;

    public void onClickDelete(String task) {
        Todos.deleteTask(task, dbHelper.getWritableDatabase());
        refreshTodos();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new TodoDBHelper(this);
        todos = Todos.getAllTasks(dbHelper.getReadableDatabase());
        btnAdd = (Button) findViewById(R.id.btnAdd);
        etNewTodo = (EditText) findViewById(R.id.etNewTodo);
        todoList = (RecyclerView) findViewById(R.id.todoList);
        todoRecyclerViewAdapter = new TodoRecyclerViewAdapter(todos, this);
        todoList.setLayoutManager(new LinearLayoutManager(this));
        todoList.setAdapter(todoRecyclerViewAdapter);
        refreshTodos();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Todos.addTask(etNewTodo.getText().toString(), dbHelper.getWritableDatabase());
                refreshTodos();
            }
        });
    }

    void refreshTodos() {
        todos = Todos.getAllTasks(dbHelper.getReadableDatabase());
        todoRecyclerViewAdapter.upDateTodos(todos);
    }
}

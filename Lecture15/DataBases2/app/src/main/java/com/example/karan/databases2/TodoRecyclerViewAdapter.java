package com.example.karan.databases2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.karan.databases2.db.TodoDBHelper;
import com.example.karan.databases2.db.tables.Todos;
import com.example.karan.databases2.models.Todo;

import java.util.ArrayList;

/**
 * Created by Karan on 05-02-2017.
 */

public class TodoRecyclerViewAdapter extends RecyclerView.Adapter<TodoRecyclerViewAdapter.TodoViewHolder> {
    private ArrayList<Todo> todos;
    private Context context;
    //private SQLiteDatabase sqLiteDatabase;

    public TodoRecyclerViewAdapter(ArrayList<Todo> todos, Context context) {
        this.todos = todos;
        this.context = context;
//        this.sqLiteDatabase = sqLiteDatabase;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View toDoItemView = li.inflate(android.R.layout.simple_list_item_checked, parent, false);
        return new TodoViewHolder(toDoItemView);
    }

    public void upDateTodos(ArrayList<Todo> todos) {
        this.todos = todos;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        holder.tvTask.setText(todos.get(position).getTaskname());
        final TodoViewHolder x = holder;
        holder.tvTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context).onClickDelete(x.tvTask.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (todos == null) {
            return 0;
        }
        return this.todos.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView tvTask;

        public TodoViewHolder(View itemView) {
            super(itemView);
            tvTask = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }
}

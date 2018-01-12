package com.example.karan.todolist;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.example.karan.todolist.models.Todos;

import java.util.ArrayList;

/**
 * Created by Karan on 14-02-2017.
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoListHolder> {
    ArrayList<Todos> todos;
    Context context;

    public TodoListAdapter(ArrayList<Todos> todos, Context context) {
        this.todos = todos;
        this.context = context;
    }

    @Override
    public TodoListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View toDoItemView = li.inflate(R.layout.todo_list_item, parent, false);
        return new TodoListHolder(toDoItemView);
    }

    public void upDateTodos(ArrayList<Todos> todos) {
        this.todos = todos;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final TodoListHolder holder, int position) {
        holder.checkedTextView.setText(todos.get(position).getTaskname());
        holder.textView.setText(todos.get(position).getDate());
        holder.checkedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.checkedTextView.setChecked(true);
                holder.checkedTextView.setPaintFlags(holder.checkedTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                holder.textView.setPaintFlags(holder.checkedTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                holder.tv_done.setVisibility(View.VISIBLE);
//                holder.checkedTextView.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.todos.size();
    }


    public class TodoListHolder extends RecyclerView.ViewHolder {
        CheckedTextView checkedTextView;
        TextView textView,tv_done;


        public TodoListHolder(View itemView) {
            super(itemView);
            checkedTextView = (CheckedTextView) itemView.findViewById(R.id.ctv_todo);
            textView = (TextView) itemView.findViewById(R.id.textView2);
            tv_done=(TextView)itemView.findViewById(R.id.tv_done);
        }
    }
}

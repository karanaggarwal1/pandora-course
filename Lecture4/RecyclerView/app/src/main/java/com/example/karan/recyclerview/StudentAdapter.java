package com.example.karan.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Karan on 18-12-2016.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {
    private ArrayList<Student> studentList;
    private Context context;
    public StudentAdapter(ArrayList<Student> studentList, Context context)
    {
        this.studentList=studentList;
        this.context=context;
    }

    @Override
    //you can return any number not like 0 to N-1 in the earlier case.
    //we don't need this as onCreateViewHolder has the viewType being passed as argument
    public int getItemViewType(int position) {
        String course=studentList.get(position).getCourse();
        if(course.equals("Pandora")||course.equals("Elixir"))
        {
            return 1;
        }
        return 0;
    }

    @Override
    //called only for new views
    //earlier we inflated to null which replaced  the earlier existing object whereas here we don't have the null option
    public StudentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(
                viewType==1?R.layout.list_item_student_1:R.layout.list_item_student,
                parent,false
        );
        return new StudentHolder(itemView);
    }

    @Override
    //called for every view recycled or new
    public void onBindViewHolder(StudentHolder holder, int position) {
        Student thisStudent=studentList.get(position);
        holder.tvName.setText(thisStudent.getName());
        holder.tvCourse.setText(thisStudent.getCourse());
        holder.tvAge.setText(String.valueOf(thisStudent.getAge()));
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    static class StudentHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvAge,tvCourse;
        public StudentHolder(View itemView) {
            super(itemView);
            this.tvName= (TextView) itemView.findViewById(R.id.tvName);
            this.tvAge= (TextView) itemView.findViewById(R.id.tvAge);
            this.tvCourse= (TextView) itemView.findViewById(R.id.tvCourse);
        }
    }
}

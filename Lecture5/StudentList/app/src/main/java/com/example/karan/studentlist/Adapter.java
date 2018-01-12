package com.example.karan.studentlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Karan on 31-12-2016.
 */

public class Adapter extends BaseAdapter{
    ArrayList<Student> students;
    Context context;
    Adapter(ArrayList students, Context context){
        this.students=students;
        this.context=context;
    }
    @Override
    public int getCount() {
        return this.students.size();
    }
    static class StudentViewHolder{
        TextView tvName,tvAge,tvCourse;
    }
    @Override
    public Object getItem(int i) {
        return this.students.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater li=(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        StudentViewHolder svHolder;
        Student thisStudent= (Student) this.getItem(i);
        if(view==null){
            view=li.inflate(R.layout.list_item_student,null);
            svHolder = new StudentViewHolder();
            svHolder.tvName = (TextView) view.findViewById(R.id.tvName);
            svHolder.tvAge = (TextView) view.findViewById(R.id.tvAge);
            svHolder.tvCourse = (TextView) view.findViewById(R.id.tvCourse);
            view.setTag(svHolder);
        }
        else
        {
            svHolder=(StudentViewHolder) view.getTag();
        }
        svHolder.tvAge.setText(thisStudent.getAge()+"");
        svHolder.tvName.setText(thisStudent.getName());
        svHolder.tvCourse.setText(thisStudent.getCourse());
        return view;
    }
}

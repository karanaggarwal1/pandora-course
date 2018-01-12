package com.example.karan.lecture3;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Karan on 17-12-2016.
 */

public class StudentListAdapter2 extends BaseAdapter{
    private ArrayList<Student> studentList;
    private Context context;
   public StudentListAdapter2(Context context)
   {
       this.studentList=new ArrayList<>();
       this.context=context;
   }
    public StudentListAdapter2(ArrayList studentList,Context context)
    {
        this.studentList=studentList;
        this.context=context;
    }
    @Override
    public int getCount() {
        return getCount(this.studentList);
    }
    private int getCount(ArrayList studentList)
    {
        return this.studentList.size();
    }
    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater li= ((Activity)this.context).getLayoutInflater();
        View itemView=li.inflate(R.layout.list_item_student,null);
        ((TextView)itemView.findViewById(R.id.tvName)).setText(studentList.get(i).getName());
        ((TextView)itemView.findViewById(R.id.tvAge)).setText(String.valueOf(studentList.get(i).getAge()));
        ((TextView)itemView.findViewById(R.id.tvCourse)).setText(studentList.get(i).getCourse());
        return itemView;
    }
}

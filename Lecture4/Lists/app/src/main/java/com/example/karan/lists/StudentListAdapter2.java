package com.example.karan.lists;

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

public class StudentListAdapter2 extends BaseAdapter {
    private ArrayList<Student> studentList;
    private Context context;

    public StudentListAdapter2(Context context) {
        this.studentList = new ArrayList<>();
        this.context = context;
    }

    public StudentListAdapter2(ArrayList studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.getCount(this.studentList);
    }

    private int getCount(ArrayList studentList) {
        return this.studentList.size();
    }

    @Override
    public Student getItem(int i) {
        return studentList.get(i);
        //used for data related specifications same for all data;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    //this creates the number of buckets
    //the return type for a view in getItemViewType is int but the return value should be like the indices of an array that is from 0 to N-1 where N is the return value of getViewTypeCount()
    //view holder pattern-to save time complexity we sacrifice some space complexity and make an object to hold the id references of a view because when the view will be recycled, the reference to the textviews will be same.
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    static class StudentViewHolder {
        TextView tvAge, tvName, tvCourse;
    }

    @Override
    public int getItemViewType(int position) {
        String course = getItem(position).getCourse();
        if (course.equals("Pandora") || course.equals("Elixir")) {
            return 1;
        }
        return 0;

    }
    //when this function is called(getView) it automatically calls getItemViewType(position) and stores it in the type bucket of the view object.
    //implicit type casting doesn't change the return type of the function in case of an override of a function because the return object will be implicitly type casted into object for the override annotation

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        long StartTime = System.currentTimeMillis();
        LayoutInflater li = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        StudentViewHolder svHolder;
        if (view == null) {
            view = li.inflate(getItemViewType(i) == 1 ? R.layout.list_item_student_1 : R.layout.list_item_student, null);
            svHolder = new StudentViewHolder();
            svHolder.tvName = (TextView) view.findViewById(R.id.tvName);
            svHolder.tvAge = (TextView) view.findViewById(R.id.tvAge);
            svHolder.tvCourse = (TextView) view.findViewById(R.id.tvCourse);
            view.setTag(svHolder);
        } else {
            svHolder = (StudentViewHolder) view.getTag();
        }

        Student thisStudent = this.getItem(i);
        svHolder.tvAge.setText(String.valueOf(thisStudent.getAge()));
        svHolder.tvName.setText(thisStudent.getName());
        svHolder.tvCourse.setText(thisStudent.getCourse());
        return view;
    }
}

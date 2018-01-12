package com.example.karan.studentlist;

/**
 * Created by Karan on 31-12-2016.
 */

public class Student {
    String name,course;
    int age;
    Student(String name,String course,int age)
    {
        this.name=name;
        this.course=course;
        this.age=age;
    }
    public String getName(){
        return this.name;
    }
    public String getCourse(){
        return this.course;
    }
    public int getAge()
    {
        return this.age;
    }
}

package com.example.karan.recyclerview;

/**
 * Created by Karan on 18-12-2016.
 */

public class Student {
    String Name;
    int age;
    String Course;

    public Student(String name, int age, String course) {
        this.Name = name;
        this.age=age;
        this.Course=course;
    }
    public String getName()
    {
        return this.Name;
    }
    public int getAge()
    {
        return this.age;
    }
    public String getCourse()
    {
        return this.Course;
    }
}

package com.example.karan.databases2.models;

/**
 * Created by Karan on 05-02-2017.
 */

public class Todo {
    String taskname;
    int id;

    public String getTaskname() {
        return taskname;
    }

    public int getId() {
        return id;
    }

    public Todo(String taskname, int id) {

        this.taskname = taskname;
        this.id = id;
    }
}

package com.example.karan.todolist.models;

import java.util.Date;

/**
 * Created by Karan on 14-02-2017.
 */


public class Todos {
    String taskname;
    int id;
    String date;

    public Todos(String taskname, int id, String date) {

        this.taskname = taskname;
        this.id = id;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getTaskname() {
        return taskname;
    }

    public int getId() {
        return id;
    }
}



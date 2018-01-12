package com.example.karan.friendlist;

import android.net.Uri;

import java.net.URI;

/**
 * Created by Karan on 04-01-2017.
 */

public class Friend {
    String name;
    int age;
    String college;
    Uri image;

    public Friend(String name, int age, String college, Uri image) {
        this.name = name;
        this.age = age;
        this.college = college;
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public String getCollege() {
        return this.college;
    }

    public int getAge() {
        return this.age;
    }

    public Uri getURI() { return this.image; }
}

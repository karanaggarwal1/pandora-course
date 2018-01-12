package com.example.karan.feed;

/**
 * Created by Karan on 28-12-2016.
 */

public class Feed {
    private String post;
    private int likes;
    Feed(int likes, String post) {
        this.likes = likes;
        this.post = post;
    }
    public int getLikes()
    {
        return this.likes;
    }
    public String getPost()
    {
        return this.post;
    }
}

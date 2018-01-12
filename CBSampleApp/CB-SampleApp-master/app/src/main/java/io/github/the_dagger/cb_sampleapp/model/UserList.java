package io.github.the_dagger.cb_sampleapp.model;

import java.util.ArrayList;

/**
 * Created by Karan on 04-02-2017.
 */

public class UserList {
    private ArrayList<SingleUser> items;

    public ArrayList<SingleUser> getUsers() {
        return items;
    }

    public void setResults(ArrayList<SingleUser> results) {
        this.items = results;
    }
}

package com.example.karan.friendlist;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class fragment_friend_list extends Fragment {
    ArrayList<Friend> friend_list=new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.friend_list,container,false);
        friend_list.add(new Friend("Akash",15,"DTU", Uri.parse("android.resource://Assignments/FriendList" + R.mipmap.default_profile_picture)));
        Adapter adapter=new Adapter(friend_list,getContext());
        RecyclerView recyclerView=(RecyclerView)rootview.findViewById(R.id.rv_friend);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return rootview;
    }
}

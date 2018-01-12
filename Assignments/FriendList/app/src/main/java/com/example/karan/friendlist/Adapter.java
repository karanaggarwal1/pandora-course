package com.example.karan.friendlist;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by Karan on 04-01-2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.FriendHolder> {
    ArrayList<Friend> friend_list;
    private Context context;
    private FragmentManager fragmentManager;

    public Adapter(Context context) {
        this.friend_list = new ArrayList<>();
        this.context = context;
    }

    public Adapter(ArrayList List, Context context) {
        this.friend_list = List;
        this.context = context;
    }

    @Override
    public FriendHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View friendView = li.inflate(R.layout.friend_list_item, parent, false);
        return new FriendHolder(friendView);
    }

    @Override
    public void onBindViewHolder(FriendHolder holder, int position) {
        final Friend thisFriend = this.friend_list.get(position);
        FriendHolder.btn_name.setText(thisFriend.getName());
        View.OnClickListener buttonClicked = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment_friend_data FragFriendData = new fragment_friend_data();
                fragmentManager=((Activity)context).getFragmentManager();
                Bundle data = new Bundle();
                data.putString("name", thisFriend.getName());
                data.putString("age", thisFriend.getAge() + "");
                data.putString("college", thisFriend.getCollege());
                data.putString("image",thisFriend.getURI()+"");
                FragFriendData.setArguments(data);
                fragmentManager.beginTransaction().replace(R.id.FragContainer, FragFriendData).commit();
            }
        };
        FriendHolder.btn_name.setOnClickListener(buttonClicked);
        FriendHolder.btn_friend_photo.setOnClickListener(buttonClicked);
    }

    @Override
    public int getItemCount() {
        return this.friend_list.size();
    }

    static class FriendHolder extends RecyclerView.ViewHolder {
        static Button btn_name;
        static ImageButton btn_friend_photo;

        public FriendHolder(View itemView) {
            super(itemView);
            this.btn_name = (Button) itemView.findViewById(R.id.btn_name);
            this.btn_friend_photo = (ImageButton) itemView.findViewById(R.id.btn_friend_photo);
        }


    }
}

package com.example.karan.friendlist;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by Karan on 05-01-2017.
 */

public class fragment_friend_data extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View friend_detail_view = inflater.inflate(R.layout.friend_details, null);
        if (getArguments() != null) {
            ((TextView) (friend_detail_view.findViewById(R.id.tv_name_details))).setText(getArguments().getString("name"));
            ((TextView) (friend_detail_view.findViewById(R.id.tv_age_details))).setText(getArguments().getString("age"));
            ((TextView) (friend_detail_view.findViewById(R.id.tv_college_details))).setText(getArguments().getString("college"));
            try {
                Bitmap bitmap=MediaStore.Images.Media.getBitmap(getContext().getContentResolver(),Uri.parse(getArguments().getString("image")));
                ((ImageView) friend_detail_view.findViewById(R.id.btn_add_image)).setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            ((TextView) (friend_detail_view.findViewById(R.id.tv_name_details))).setText("");
            ((TextView) (friend_detail_view.findViewById(R.id.tv_age_details))).setText("");
            ((TextView) (friend_detail_view.findViewById(R.id.tv_college_details))).setText("");
        }
        return friend_detail_view;
    }
}

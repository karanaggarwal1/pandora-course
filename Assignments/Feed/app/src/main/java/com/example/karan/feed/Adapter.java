package com.example.karan.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Karan on 28-12-2016.
 */

public class Adapter extends BaseAdapter {
    private ArrayList<Feed> feed;
    private Context context;

    public Adapter(ArrayList feed, Context context) {
        this.feed = feed;
        this.context = context;
    }

    static class viewHolder {
        TextView post, likes;
        Button like;
    }

    @Override
    public int getCount() {
        return this.feed.size();
    }

    @Override
    public Object getItem(int i) {
        return this.feed.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int x = i;
        LayoutInflater li = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = li.inflate(R.layout.post_feed, null);
        final viewHolder feedHolder = new viewHolder();
        feedHolder.post = (TextView) view.findViewById(R.id.tvPost);
        feedHolder.likes = (TextView) view.findViewById(R.id.tvLikes);
        feedHolder.like = (Button) view.findViewById(R.id.like);
        view.setTag(feedHolder);
        final Feed thisFeed = (Feed) this.getItem(i);
        feedHolder.post.setText(thisFeed.getPost());
        feedHolder.likes.setText(thisFeed.getLikes() + " Likes");
        View.OnClickListener proceedClicked = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.like) {
                    feed.set(x, new Feed(thisFeed.getLikes() + 1, thisFeed.getPost()));
                    feedHolder.likes.setText(thisFeed.getLikes()+1 + " Likes");
                }
            }
        };
        feedHolder.like.setOnClickListener(proceedClicked);
        feedHolder.likes.setText(feed.get(i).getLikes() + " Likes");
        return view;
    }
}

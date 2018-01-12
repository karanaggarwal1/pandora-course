package com.example.karan.volleyjson;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.karan.volleyjson.models.Post;

import java.util.ArrayList;

/**
 * Created by Karan on 26-01-2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
    private ArrayList<Post> postList;
    private Context context;

    public PostAdapter(ArrayList<Post> postList, Context context) {
        this.postList = postList;
        this.context = context;
    }

    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_json_item, parent, false);
        return new PostHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position) {
        Post thisPost = postList.get(position);
        holder.tvId.setText(thisPost.getId() + "");
        holder.tvbody.setText(thisPost.getBody());
        holder.tvTitle.setText(thisPost.getTitle());
        holder.tvUserId.setText(thisPost.getUserId() + "");
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class PostHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvUserId, tvTitle, tvbody;

        public PostHolder(View itemView) {
            super(itemView);
            this.tvId = (TextView) itemView.findViewById(R.id.tvUserId);
            this.tvUserId = (TextView) itemView.findViewById(R.id.tvid);
            this.tvTitle = (TextView) itemView.findViewById(R.id.tvtitle);
            this.tvbody = (TextView) itemView.findViewById(R.id.tvbody);
        }
    }
}

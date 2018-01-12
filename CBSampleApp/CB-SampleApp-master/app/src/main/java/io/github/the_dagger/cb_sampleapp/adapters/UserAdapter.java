package io.github.the_dagger.cb_sampleapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import io.github.the_dagger.cb_sampleapp.R;
import io.github.the_dagger.cb_sampleapp.model.SingleUser;

/**
 * Created by Karan on 04-02-2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    public ArrayList<SingleUser> users;
    private Context context;

    public UserAdapter(ArrayList<SingleUser> users) {
        this.users=users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new UserAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_movie, null));
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
        holder.textView.setText(users.get(position).getLogin());
        String poster = users.get(position).getAvatarURL();
        //TODO : remove fit and check what happens
        Picasso.with(context)
                .load(poster)
                .fit()
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.movie_name);
            imageView = (ImageView) itemView.findViewById(R.id.movie_image);
        }
    }
}

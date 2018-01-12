package io.github.the_dagger.cb_sampleapp.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;

import io.github.the_dagger.cb_sampleapp.R;
import io.github.the_dagger.cb_sampleapp.adapters.UserAdapter;

import io.github.the_dagger.cb_sampleapp.model.SingleUser;
import io.github.the_dagger.cb_sampleapp.model.UserList;
import io.github.the_dagger.cb_sampleapp.rest.TheUserDbAi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity {

    ArrayList<SingleUser> singleUserArrayList;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        singleUserArrayList = new ArrayList<>();
        userAdapter = new UserAdapter(singleUserArrayList);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TheUserDbAi theUserDbAi = new TheUserDbAi();
        theUserDbAi.getUserClient().getUserList().enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                for (SingleUser singleUser : response.body().getUsers()) {
                    Log.e("User", singleUser.getLogin());
                    singleUserArrayList.add(singleUser);
                    Log.e("Size", String.valueOf(response.code()));
                    userAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<UserList> call, Throwable t) {

            }

        }  );


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movieRecyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(userAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

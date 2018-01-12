package com.example.karan.feed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static ListView feeds;
    static final ArrayList<Feed> feed = new ArrayList<>();
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        feeds = (ListView) findViewById(R.id.lvFeed);
        Adapter feedAdapter;
        btnAdd = (Button) findViewById(R.id.btnAdd);
        View.OnClickListener buttonClicked = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btnAdd) {
                    Intent i=new Intent(MainActivity.this,addPost.class);
                    startActivity(i);
                }
            }
        };
        feedAdapter = new Adapter(feed, this);
        feeds.setAdapter(feedAdapter);
        btnAdd.setOnClickListener(buttonClicked);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

package com.example.karan.feed;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Karan on 28-12-2016.
 */

public class addPost extends AppCompatActivity {
    EditText post_data;
    Button proceed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("inaddPost", "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_post);
        post_data = (EditText) findViewById(R.id.post_data);
        proceed = (Button) findViewById(R.id.proceed);
        View.OnClickListener buttonClicked = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.proceed) {
                    String data = post_data.getText().toString();
                    Feed addFeed = new Feed(0, data);
                    MainActivity.feed.add(addFeed);
                    Log.d("H", "onClick: " + MainActivity.feed.size());
                    finish();
                }
            }
        };
        proceed.setOnClickListener(buttonClicked);

    }
}

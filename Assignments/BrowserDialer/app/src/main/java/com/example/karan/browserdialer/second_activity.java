package com.example.karan.browserdialer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class second_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        TextView textView = (TextView) findViewById(R.id.textView);
        Intent i = getIntent();
        if (i.getStringExtra("uri browse") != null) {
            textView.setText(i.getStringExtra("uri browse"));
        } else {
            textView.setText(i.getStringExtra("uri dial"));
        }
        finish();
    }
}

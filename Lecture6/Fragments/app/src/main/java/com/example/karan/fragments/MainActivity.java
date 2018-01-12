package com.example.karan.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    static int x = 0;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(x+"");
    }
    public void increment(){
        x++;
        textView.setText(x+"");
    }
    public void decrement() {
        x--;
        textView.setText(x+"");
    }
}

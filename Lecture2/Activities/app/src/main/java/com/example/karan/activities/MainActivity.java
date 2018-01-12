package com.example.karan.activities;

import android.app.Activity;
import android.content.Context;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    public static final String TAG= "MainAct";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.i(TAG, "onCreate: Info");
//        Log.v(TAG, "onCreate: Verbose");//used to give information about changes in system activity//example:changes in networks like wifi to 3g-4g etc
//        Log.d(TAG, "onCreate: Debug");
//        Log.w(TAG, "onCreate: Warning");
//        Log.e(TAG, "onCreate: Error");//coloured
//        Log.wtf(TAG, "onCreate: WTF");//coloured//what a terrible failure
        //filter helps to give that log and all logs after that
}
    EditText etnum1,etnum2;//not necessary to give same name as id variables
    Button btnAdd;
    TextView tvResult;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
        //code is written here, to allow the OS to do stuff and then write whatever we want to.
        //our logic goes here.
        //if work is to be done after action X.
        etnum1=(EditText) findViewById(R.id.etnum1);
        etnum2=(EditText) findViewById(R.id.etnum2);
        btnAdd=(Button) findViewById(R.id.btnAdd);
        tvResult=(TextView) findViewById(R.id.tvResult);

//        View.OnClickListener ocl = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        };
//
//        btnAdd.setOnClickListener(ocl);

        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                addAndShow();
            }
        });
        //Log.d(TAG, "onCreate: ");
        //finish() will terminate the activity before it is even started properly.
        //MainActivity m = new MainActivity(); creates a zombie,does nothing but just consumes RAM.

    }
    //Home button calls onStop();
    //back button destroys the app
    void addAndShow(){
        int a=Integer.valueOf(etnum1.getText().toString());
        int b=Integer.valueOf(etnum2.getText().toString());
        int c=a+b;
        tvResult.setText(String.valueOf(c));
    }
    @Override
    protected void onStart() {
        super.onStart();
        //our logic goes here.
        //if work is to be done after action X.
        //Log.d(TAG, "onStart: ");
    }
    //even when app is in background or in recents it is onStop();
    @Override//compile time annotation that checks if a super class function is being overridden or not.
    //certain annotations can be changed using annotations.
    protected void onResume() {
        super.onResume();
        //our logic goes here.
        //if work is to be done after action X.
        //Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Log.d(TAG, "onPause: ");
    }
    //if app is opened from recents onRestart() is called.
    @Override
    protected void onDestroy() {
        //our logic goes here.
        //if work is to be done before action X.
        super.onDestroy();
        //Log.d(TAG, "onDestroy: ");
    }
    /*
    even when app is in background or in recents and is removed it is onStop();
    when multiple apps are opened in recents, onDestroy() function is not called because this process is drastic and the private variables assume new values.
    that's why private variables are not safe.
    on signifies when os does some work. So if onCreate() is called it does not create activity it is called when the activity happens.
    finish() is the function via which we can close an activity.
    */
    //sdk manager-> sources for android sdk,helps to view source code,ctrl+click
}





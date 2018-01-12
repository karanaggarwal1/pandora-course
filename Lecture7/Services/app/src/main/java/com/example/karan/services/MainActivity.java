package com.example.karan.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        Button stop = (Button) findViewById(R.id.button2);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.button) {

                }
            }
        });
    }

    //UI Thread exists in Android
    //if you are not able to resolve problems with UI,it is possible that UI thread is faulty
    //thus the UI thread should not do blocking tasks
    //the tags in a service-exported,enabled
    //exported-the components of the other apps can access it
    //enabled-service can be automatically started or needs the user to start it i.e. through intents
    //by default the two tags have false value
    //onCreate and onStart functions exist in a service
    //UI thread is just a concept
    //whenever app is changed UI thread is transferred depending on what app is selected
    //it is a terminology given to any thread being run
    //when OS recreates the service it starts it with a null intent
    //using this it can be checked via what source was the service started
    //start_sticky is the default value enables us to check if the activity was started by system or user.
    //to use the service outside an app in other app add an intent filter with the action tag containing the name of the action
    @Override
    public void onClick(View view) {
        Intent i = new Intent(MainActivity.this, MyIntentService.class);
        startService(i);
    }

    private void loopwithlog(int duration) {
        for (int i = 0; i < duration; i++) {
            loopOneSec();
            Log.d("MainAct", "loopwithlog: " + i);
        }
    }

    private void loopOneSec() {
        long StartTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - StartTime < 1000) ;
    }
}

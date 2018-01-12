package com.example.karan.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {
    //it is possible that at the time the action is to be done, the activity may not be running
    //we need to store that intent for a later time
    //such an intent is known as pending intent
    //request code, to cancel this pending event
    //pending event saves the new Intent's context as well

    LoginButton loginButton=new LoginButton(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                123,
                new Intent(this, AlarmActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK),
                0
        );
        //currentTimeMillis() returns time in terms of RTC
//        alarmManager.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + 60 * 1000, pendingIntent);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 60 * 1000, 60 * 1000, pendingIntent);

    }
}

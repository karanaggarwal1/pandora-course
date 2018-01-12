package com.example.karan.broadcasts;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    BroadcastReceiver broadcastReceiver;
    IntentFilter intentFilter;

    //register receiver function available in any context can be started from any activity service
    //now if we are making any changes to the UI using this receiver we need to execute following steps(*)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent("some.intent.string");
        textView = (TextView) findViewById(R.id.textView);
        sendBroadcast(i);
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
//                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
//                float x = intent.getFloatExtra(BatteryManager.EXTRA_LEVEL, -1);
//                int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 100);
//                Log.d("MA", "onReceive: " + scale);
                //the API still says that you should calculate the battery with scale even though after kitkat it return a 100 scaled value
                //the correct way is String.
                textView.setText(intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0) + "%");
            }
        };
        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(broadcastReceiver);
        super.onPause();
    }
}

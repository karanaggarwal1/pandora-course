package com.example.karan.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG="srvc";
    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        long startTime=System.currentTimeMillis();
        while(System.currentTimeMillis()-startTime<10000);
        Log.d(TAG, "onCreate: after 10 seconds");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: " );
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

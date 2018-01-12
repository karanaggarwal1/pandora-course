package com.example.karan.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Karan on 07-01-2017.
 */

public class MyIntentService extends IntentService {
    private static final String name="NAME";
    //
    public MyIntentService() {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        loopwithlog(10);
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

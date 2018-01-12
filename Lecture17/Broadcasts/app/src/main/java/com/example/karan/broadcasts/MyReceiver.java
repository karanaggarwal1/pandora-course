package com.example.karan.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    //exported defines whether the broadcast can be started by other apps's broadcasts or not
    //now whenever the intent of power connected and disconnected, onReceive will work
    //activity and service both extend ContextWrapper
    //the receiver doesn't have itself a context
    //don't do long running tasks with this context
    //because this context has a validity period
    //create a service and do that task in that,if in background
    //or create an activity for foreground work
    //statically registered broadcast receiver because broadcasts are written in manifest
    //activity's UI thread access is not avaialbale
    //some broadcasts are infrequent like charger connected/disconnected
    //broadcasts like change of battery level is received frequently
    //these broadcasts are not allowed in manifest
    //because they will never allow android to sleep
    //we will create such a broadcast dynamically

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
            Toast.makeText(context, "CHARGER DISCONNECTED", Toast.LENGTH_SHORT).show();
        }
//        if (intent.getAction().equals("some.intent.string")) {
//            Toast.makeText(context, "stupid broadcast", Toast.LENGTH_SHORT).show();
//        }
        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            Toast.makeText(context, "CHARGER CONNECTED", Toast.LENGTH_SHORT).show();
        }
        Intent i = new Intent(context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(i);
    }
}

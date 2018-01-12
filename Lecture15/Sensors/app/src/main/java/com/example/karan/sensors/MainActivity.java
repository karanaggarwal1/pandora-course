package com.example.karan.sensors;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    public static final String TAG = "SENSORS";
    //the accelerometer can act as a gyrometer and vice-versa
    //a phone can have multiple sensors of the same type
    //we can have software and hardware sensors
    SensorManager sensorManager;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);
        List<Sensor> mySensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : mySensors) {
            Log.d(TAG, "onCreate: name:" + sensor.getName());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
                Log.d(TAG, "onCreate: type:" + sensor.getStringType());
            }
            Log.d(TAG, "onCreate: vendor:" + sensor.getVendor());
            Log.d(TAG, "onCreate: version:" + sensor.getVersion());
            Log.d(TAG, "onCreate: ===============================================");
        }
        Sensor accelSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        Sensor proxSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        //on what event does the listener have to be set, can't be done for multiple sensors in a single line
        //some sensors are very accurate, so we need to specify the time period after which the value is to be updated-has to be greater than or equal to 6000 and if not
        //it is coerced and made to 6000, microseconds.
        //we can also have a maximum latency argument of type int which signifies the number of sensors that can run in sync together if i's value is high then multiple sensors can
        //run together hence saving power but accuracy will be degraded
        //for the screen the accelerometer is calibrated as y axis on the longer side and x axis on the shorter side however at the screen level it is just the opposite however
        //z axis is same for both that is inside the screen

        sensorManager.registerListener(this, lightSensor, 1000 * 1000);
        sensorManager.registerListener(this, accelSensor, 1000 * 1000);
        sensorManager.registerListener(this, proxSensor, 1000 * 1000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            Log.d(TAG, "onSensorChanged: LIGHT" + event.values[0]);
            if (event.values[0] > 5) {
                relativeLayout.setBackgroundColor(Color.WHITE);
            } else {
                relativeLayout.setBackgroundColor(Color.BLACK);
            }
        }
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            relativeLayout.setBackgroundColor(Color.rgb(accelToCol(event.values[0]), accelToCol(event.values[1]), accelToCol(event.values[2])));
        }
//        Log.d(TAG, "onSensorChanged: ax" + event.values[0]);
//        Log.d(TAG, "onSensorChanged: ay" + event.values[1]);
//        Log.d(TAG, "onSensorChanged: az" + event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    int accelToCol(float accel) {
        accel = accel + 12;
        return (int) ((accel / 24) * 255);
    }
}

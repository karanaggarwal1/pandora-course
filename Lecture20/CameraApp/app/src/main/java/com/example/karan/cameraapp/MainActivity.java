package com.example.karan.cameraapp;

import android.hardware.Camera;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Camera";
    Camera camera = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        if (camera == null) {
            camera = Camera.open();
        }

        List<Camera.Size> pictureSizes = camera.getParameters().getSupportedPictureSizes();
        List<Camera.Size> videoSizes = camera.getParameters().getSupportedVideoSizes();
        List<Camera.Size> previewSizes = camera.getParameters().getSupportedPreviewSizes();
        int counter = 0;
        for (Camera.Size size : pictureSizes) {
            Log.d(TAG, "onCreate: " + size.width + " " + size.height + " " + ++counter);
        }
        Log.d(TAG, "onCreate: " + "*****************************");
        for (Camera.Size size : videoSizes) {
            Log.d(TAG, "onCreate: " + size.width + " " + size.height + " " + ++counter);
        }
        Log.d(TAG, "onCreate: " + "*****************************");
        for (Camera.Size size : previewSizes) {
            Log.d(TAG, "onCreate: " + size.width + " " + size.height + " " + ++counter);
        }
        camera.getParameters().setPictureSize(4160, 3120);
        final Camera.PictureCallback pictureCallback = new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                Log.d(TAG, "onPictureTaken: " + data.length);
                camera.stopPreview();
                camera.startPreview();
                File file = new File(Environment.getExternalStorageDirectory().getPath() + "/kds" + System.currentTimeMillis() + ".jpg");
                if (file == null) {
                    return;
                }
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(data);
                    fos.close();
                } catch (FileNotFoundException e) {
                    Log.d(TAG, "File not found: " + e.getMessage());
                } catch (IOException e) {
                    Log.d(TAG, "Error accessing file: " + e.getMessage());
                }
            }
        };
        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camera.takePicture(null, null, pictureCallback);
                //shutterCallback shutter,PictureCallBack(raw),PictureCallback(jpeg)
                //raw image row major form of pixels
                //each cell will have rgb value got from camera sensors
                //raw mode-sensor pixels saved, the raw photo is processed separately
                //take a raw photo, convert it to jpeg in ahigh processing machine
            }
        });
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        //CameraPreview preview=(CameraPreview)findViewById(R.id.preview);
        //preview.initialise(camera);
        int rotation = 0;
        switch (getWindowManager().getDefaultDisplay().getRotation()) {
            case Surface.ROTATION_0:
                rotation = 90;
                break;
            case Surface.ROTATION_90:
                rotation = 0;
                break;
            case Surface.ROTATION_270:
                rotation = 180;
                break;
        }
        camera.setDisplayOrientation(rotation);
        CameraPreview cameraPreview = new CameraPreview(this, camera);
        frameLayout.addView(cameraPreview);
    }

    //the graphics camera is a virtual camera
    //we are using a deprecated method
    //a pre released api-documentation not available-beta stage-definition can be changed-shouldn't be used often
    //an api becomes released-becomes part of the documentation
    //compile time annotation-just a warning(@Deprecated)-recommended-shouldn't be used
    //Alarm.setRepeating()
    //@Disabled-can't be used
    //there are certain unsafe methods
    //we need to close camera after opening it, otherwise it results in a memory leak, and the phone has to be restarted
    //Open camera.open(),iterates all camera,and opens the backfacing camera
    @Override
    protected void onStop() {
        camera.release();
        super.onStop();
    }
}

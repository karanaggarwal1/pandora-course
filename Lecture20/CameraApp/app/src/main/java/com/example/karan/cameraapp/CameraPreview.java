package com.example.karan.cameraapp;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by Karan on 25-02-2017.
 */
//if we implement SurfaceHolder.callback,surfaceholder-enables changes that happen on the surface
//display works using frameBuffers
//the rate at which is being displayed
//50fps
//lag-next frame is not ready,so it waits
//larger GPU-more frames can be stored
//buffers could be in a queue,stack depending on implementation
//by default they use push type buffers
//needed to define ^^^^ this for android versions lower than 3.0
//how the buffers are saved
//surface-ram needs to be allocated
//it is not instantly added
//surface created-called as soon as the surface created
//if screen rotated-surfaceCreated-surfaceChanged-surfaceCreated
//surface callback-listener to all three events fo surface being changed,created or destroyed
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private Camera camera;
    private SurfaceHolder holder;
    private boolean initialised = false;
    //create a setCamera method
    //and execute the three methods
    //**************
    //or create a view in Java
    //create a framelayout and add this view in this dynamically

    public CameraPreview(Context context, Camera camera) {
        super(context);
        this.camera = camera;
        this.holder = getHolder();
        holder.addCallback(this);
        this.initialised = true;
    }

    public CameraPreview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CameraPreview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void initialise(Camera camera) {
        if (this.initialised) {
            return;
        }
        this.camera = camera;
        this.holder = getHolder();
        holder.addCallback(this);
        this.initialised = true;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            camera.setPreviewDisplay(holder);
            camera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if (holder.getSurface() == null) {
            return;
        }
        camera.stopPreview();
        try {
            camera.getParameters().setPreviewSize(width, height);//apparently no significant effect
            camera.setPreviewDisplay(holder);
            camera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}

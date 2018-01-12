package com.example.karan.mediaplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Uri to create the file
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.audio);
        //to make sure that URI is of music type we use prepare
        //we should always do the prepare work on a separate thread
        //it is a background service so you need to close that service as well for full control

//        try {
//            mediaPlayer.prepare();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        mediaPlayer.start();

    }
}

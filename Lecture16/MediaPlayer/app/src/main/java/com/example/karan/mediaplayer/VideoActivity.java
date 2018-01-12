package com.example.karan.mediaplayer;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://com.example.karan.mediaplayer/" + R.raw.video));
//      videoView.setVideoURI(Uri.parse("android.resource://com.example.karan.mediaplayer/raw/video"));
        //^^^this also works
        videoView.start();
        //android.resource is a protocol
    }
}

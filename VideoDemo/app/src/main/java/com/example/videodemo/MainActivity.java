package com.example.videodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        VideoView videoViewMain = findViewById(R.id.videoViewMain);

        videoViewMain.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.demovideo);

        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(videoViewMain);

        videoViewMain.setMediaController(mediaController);

        videoViewMain.start();
    }

    private void loadVideo()
    {
        VideoView videoViewMain = findViewById(R.id.videoViewMain);

        videoViewMain.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.demovideo);
    }

    public void OnBtnClick(View view)
    {
        VideoView videoViewMain = findViewById(R.id.videoViewMain);

        videoViewMain.start();


    }
}

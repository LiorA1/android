package com.example.basicphrases;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    MediaPlayer MP;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init an MediaPlayer :
        MP = MediaPlayer.create(this, R.raw.doyouspeakenglish);

    }

    public void OnBtnClick_Hello(View view)
    {
        if(MP.isPlaying())
        {
            MP.pause();
        }
        else
        {
            MP = MediaPlayer.create(this, R.raw.hello);
            MP.start();
        }

    }

    public void OnBtnClick_Please(View view)
    {
        if(MP.isPlaying())
        {
            MP.pause();
        }
        else
        {
            MP = MediaPlayer.create(this, R.raw.please);
            MP.start();
        }

    }

    public void OnBtnClick_Welcome(View view)
    {
        if(MP.isPlaying())
        {
            MP.pause();
        }
        else
        {
            MP = MediaPlayer.create(this, R.raw.welcome);
            MP.start();
        }

    }

    public void OnBtnClick_MyNameIs(View view)
    {
        if(MP.isPlaying())
        {
            MP.pause();
        }
        else
        {
            MP = MediaPlayer.create(this, R.raw.mynameis);
            MP.start();
        }

    }

    public void OnBtnClick_ILiveIn(View view)
    {
        if(MP.isPlaying())
        {
            MP.pause();
        }
        else
        {
            MP = MediaPlayer.create(this, R.raw.ilivein);
            MP.start();
        }

    }

    public void OnBtnClick_HowAreYou(View view)
    {
        if(MP.isPlaying())
        {
            MP.pause();
        }
        else
        {
            MP = MediaPlayer.create(this, R.raw.howareyou);
            MP.start();
        }

    }

    public void OnBtnClick_GoodEvening(View view)
    {
        if(MP.isPlaying())
        {
            MP.pause();
        }
        else
        {
            MP = MediaPlayer.create(this, R.raw.goodevening);
            MP.start();
        }

    }

    public void OnBtnClick_DYSE(View view)
    {
        if(MP.isPlaying())
        {
            MP.pause();
        }
        else
        {
            MP = MediaPlayer.create(this, R.raw.doyouspeakenglish);
            MP.start();
        }

    }


}

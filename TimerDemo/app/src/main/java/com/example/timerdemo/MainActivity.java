package com.example.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountDownTimer firstCounter = new CountDownTimer(10000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                Log.i("seconds Left!", String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Log.i("We're done!", "No More countdown!!");
            }
        };


        firstCounter.start();

        // CountDownTimer is best for a timer.

        // The following, is more suitable for other work.



        final Handler handler = new Handler();

        /*
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.i("Hey it's us", "A second passed by");

                handler.postDelayed(this, 1000);
            }
        };
        //*/

        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.v("Hey,", " it's the second Runnable!! WOW!!");

                handler.postDelayed(this, 1000);
            }
        });












    }
}

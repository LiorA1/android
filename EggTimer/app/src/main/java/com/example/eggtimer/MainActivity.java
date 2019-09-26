package com.example.eggtimer;

import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class MainActivity extends AppCompatActivity
{
    boolean flag = false;
    final int MIN_SECONDS_TIME = 5;
    final int DEFAULT_SECONDS_TIME = 30;
    Button buttonTimer;
    TextView textViewTime;
    SeekBar TimerControl;
    int seconds = DEFAULT_SECONDS_TIME;
    CountDownTimer firstCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonTimer = findViewById(R.id.buttonTime);
        TimerControl = findViewById(R.id.seekBarTime);
        textViewTime = (TextView) findViewById(R.id.textViewTime);

        // Convert the progress bar (represent time in seconds) to seconds and minutes.
        // And set the values in the textView:
        int min = seconds / 60;
        int sec = seconds % 60;
        String str = min + " : " + sec;
        textViewTime.setText(str);

        firstCounter = new CountDownTimer(DEFAULT_SECONDS_TIME * 1000, 1000)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                // Each Tick, we need to update the viewText.
                seconds = (int)MILLISECONDS.toSeconds(millisUntilFinished);
                int min = seconds / 60;
                int sec = seconds % 60;

                String str = min + " : " + sec;
                textViewTime.setText(str);

            }

            @Override
            public void onFinish()
            {
                // When over need to sound the horn !.
                Log.d("CountDownTimer : ", "Count has finished !");

            }
        };

        int maxValue = 600;
        TimerControl.setMax(maxValue);
        TimerControl.setProgress((int) DEFAULT_SECONDS_TIME);



        TimerControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, final int progress, boolean fromUser)
            {
                // Check for minimum time :
                if(progress < MIN_SECONDS_TIME)
                {
                    seconds = MIN_SECONDS_TIME;
                }
                else
                {
                    seconds = progress;
                }

                // Convert the progress bar (represent time in seconds) to seconds and minutes.
                // And set the values in the textView:
                int min = seconds / 60;
                int sec = seconds % 60;
                String str = min + " : " + sec;
                textViewTime.setText(str);

                // Setting the counter, that get millisInFuture and interval.
                firstCounter = new CountDownTimer(seconds * 1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished)
                    {
                        // Each Tick, we need to update the viewText.
                        seconds = (int)MILLISECONDS.toSeconds(millisUntilFinished);
                        int min = seconds / 60;
                        int sec = seconds % 60;

                        String str = min + " : " + sec;
                        textViewTime.setText(str);

                    }

                    @Override
                    public void onFinish()
                    {
                        // When over need to sound the horn !.
                        Log.d("CountDownTimer : ", "Count has finished !");

                    }
                };

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }



    public void btnGoStop(View view)
    {
        if(flag)
        {
            // flag is true == stop running.
            // redefine the timer, enable the seekbar.
            // Change the text in the button.
            flag = false;
            TimerControl.setEnabled(true);

            firstCounter.cancel();


            buttonTimer.setText("Go!");
        }
        else
        {
            // flag is false == start running.
            // - disable the seekbar.
            // Change the text in the button.
            flag = true;
            TimerControl.setEnabled(false);
            firstCounter.start();

            buttonTimer.setText("Stop!");


        }

    }
}

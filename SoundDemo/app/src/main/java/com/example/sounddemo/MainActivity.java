package com.example.sounddemo;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
{
    MediaPlayer MP;
    AudioManager  audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init the audioManager to the device Audio Service.
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        // init the resource 'harley', to the 'MP' mediaPlayer.
        MP = MediaPlayer.create(this, R.raw.harley);
        // attach the volume seekbar.
        SeekBar volumeControl = findViewById(R.id.seekBarVolume);
        // attach the progress seekbar.
        final SeekBar ProgressControl = findViewById(R.id.seekBarProgress);

        // getting the maxVolume in the current device.
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        // set the max volume possible in the device.
        volumeControl.setMax(maxVolume);
        volumeControl.setProgress(currentVolume);

        ProgressControl.setMax(MP.getDuration());



        ProgressControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                Log.v("progress seekbar:", Integer.toString(progress));
                MP.seekTo(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                MP.pause();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                MP.start();

            }
        });

        new Timer().scheduleAtFixedRate(
                new TimerTask() {
                    @Override
                    public void run()
                    {
                        ProgressControl.setProgress(MP.getCurrentPosition());
                    }
                },
                0,
                300
        );




        // Listener (see DP) of changes in the seekbar of the volume.
        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                // sets the volume of the video to the current value of the seekbar.
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void OnStart(View view)
    {
        MP.start();
    }

    public void OnPause(View view)
    {
        MP.pause();
    }
}

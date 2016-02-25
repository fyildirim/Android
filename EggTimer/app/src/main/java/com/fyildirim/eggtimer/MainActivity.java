package com.fyildirim.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView seekBarValue;
    SeekBar seekBar;
    Button knop;
    int progressvalue;
    int progressmins;
    int progresssecs;
    boolean isactive = false;
    MediaPlayer mp;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBarValue = (TextView)findViewById(R.id.textView);
        mp = MediaPlayer.create(this, R.raw.alarm);
        knop = (Button) findViewById(R.id.button);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            int minutes = progressvalue / 60 - progressvalue % 60;
//            int seconds = progressvalue - (minutes*60);


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressvalue = progress;
                int minutes = (int) (double) progressvalue / 60;
                int seconds = progressvalue % 60;
                String str = String.format("%d:%02d", minutes, seconds);
                seekBarValue.setText(getString(R.string.time, str));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                int minutes = (int) (double) progressvalue / 60;
                int seconds = progressvalue % 60;
                String str = String.format("%d:%02d", minutes, seconds);
                seekBarValue.setText(getString(R.string.time, str));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBarValue.setText("");
            }


        });
    }
    public void startCountdown(View view) {
        if (isactive == true) {
            progressvalue = seekBar.getProgress();
            timer.cancel();
            isactive = false;
            knop.setText("OK");
        } else {
            timer = new CountDownTimer(progressvalue * 1000, 1000) {

                public void onTick(long millisUntilFinished) {
                    isactive = true;
                    int minutes = (int) (double) (millisUntilFinished / 1000) / 60;
                    int seconds = (int) (millisUntilFinished / 1000) % 60;
                    String str = String.format("%d:%02d", minutes, seconds);
                    seekBarValue.setText(getString(R.string.time, str));
                    knop.setText("CANCEL");
                }

                public void onFinish() {
                    mp.start();
                    isactive = false;
                    knop.setText("OK");
                    String str = String.format("%d:%02d", 0, 0);
                    seekBarValue.setText("");
                }
            }.start();
        }
    }

}

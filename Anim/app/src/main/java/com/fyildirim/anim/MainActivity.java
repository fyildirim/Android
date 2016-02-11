package com.fyildirim.anim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView bart;
    ImageView homer;
    SeekBar seekBar;
    TextView seekBarValue;
    int progressbar = 50;
    boolean bartShowing = true;
    RadioGroup rg;
    int currentRadio = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bart = (ImageView) findViewById(R.id.bartfoto);
        homer = (ImageView) findViewById(R.id.homerfoto);
        seekBar = (SeekBar)findViewById(R.id.seekbar);
        final TextView seekBarValue = (TextView)findViewById(R.id.seekbarvalue);
        RadioGroup rg = (RadioGroup) findViewById(R.id.radios);
        homer.animate().alpha(0f).setDuration(0);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.fade: {
                        currentRadio = 1;
                        bart.animate().translationX(0l).setDuration(0);
                        homer.animate().translationX(0l).setDuration(0);
                        homer.animate().scaleX(1f).setDuration(0);
                        homer.animate().scaleY(1f).setDuration(0);
                        bart.animate().scaleX(1f).setDuration(0);
                        bart.animate().scaleY(1f).setDuration(0);
                        bart.animate().rotation(0f).setDuration(0);
                        homer.animate().rotation(0f).setDuration(0);
                        if(bartShowing) {
                            bart.animate().alpha(1f).setDuration(0);
                            homer.animate().alpha(0f).setDuration(0);
                        } else {
                            homer.animate().alpha(1f).setDuration(0);
                            bart.animate().alpha(0f).setDuration(0);
                        }
                        break;
                    }


                case R.id.rotate: {
                    currentRadio = 2;
                    bart.animate().rotation(0f).setDuration(0);
                    homer.animate().rotation(0f).setDuration(0);
                    homer.animate().alpha(1f).setDuration(0);
                    bart.animate().alpha(1f).setDuration(0);
                    if (bartShowing) {
                        homer.animate().translationX(0l).setDuration(0);
                        bart.animate().translationX(0l).setDuration(0);
                        homer.animate().scaleX(0f).setDuration(0);
                        homer.animate().scaleY(0f).setDuration(0);
                    } else {
                        homer.animate().translationX(0l).setDuration(0);
                        bart.animate().translationX(0l).setDuration(0);
                        bart.animate().scaleX(0f).setDuration(0);
                        bart.animate().scaleY(0f).setDuration(0);
                    }
                    break;
                }

                case R.id.translate: {
                    currentRadio = 3;
                    homer.animate().alpha(1f).setDuration(0);
                    bart.animate().alpha(1f).setDuration(0);
                    homer.animate().scaleX(1f).setDuration(0);
                    homer.animate().scaleY(1f).setDuration(0);
                    bart.animate().scaleX(1f).setDuration(0);
                    bart.animate().scaleY(1f).setDuration(0);
                    bart.animate().rotation(0f).setDuration(0);
                    homer.animate().rotation(0f).setDuration(0);
                    if (bartShowing) {
                        homer.animate().translationX(-1000l).setDuration(0);
                        bart.animate().translationX(0l).setDuration(0);
                    } else {
                        bart.animate().translationX(1000l).setDuration(0);
                        homer.animate().translationX(0l).setDuration(0);
                    }
                    break;
                }
            }


        }
    });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                seekBarValue.setText("Speed: " + String.format("%.2f", (double) 5 - progress * 0.05) + "s");
                progressbar = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                seekBarValue.setText("Speed: " + String.format("%.2f", (double) 5 - progressbar * 0.05) + "s");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBarValue.setText("");
                // TODO Auto-generated method stub
            }
        });
    }

    public void animate(View view) {
        if(bartShowing) {
            bartShowing = false;
            switch (currentRadio) {
                case 1: {
                    bart.animate().alpha(0f).setDuration(5000-(progressbar*50));
                    homer.animate().alpha(1f).setDuration(5000-(progressbar*50));
                    break;
                }
                case 2: {
                    homer.animate().alpha(1f).setDuration(0);
                    bart.animate().rotation(1080f).setDuration(5000-(progressbar*50));
                    homer.animate().rotation(-1080f).setDuration(5000 - (progressbar*50));
                    bart.animate().scaleX(0f).setDuration(5000 - (progressbar * 50));
                    bart.animate().scaleY(0f).setDuration(5000 - (progressbar * 50));
                    homer.animate().scaleX(1f).setDuration(5000 -(progressbar*50));
                    homer.animate().scaleY(1f).setDuration(5000-(progressbar*50));
                    break;
                }
                case 3: {
                    bart.animate().translationX(1000l).setDuration(5000-(progressbar*50));
                    homer.animate().translationX(0l).setDuration(5000-(progressbar*50));
                    break;
                }
            }
        } else {
            bartShowing = true;
            switch (currentRadio) {
                case 1: {
                    bart.animate().alpha(1f).setDuration(5000-(progressbar*50));
                    homer.animate().alpha(0f).setDuration(5000-(progressbar*50));
                    break;
                }
                case 2: {
                    bart.animate().rotation(-1080f).setDuration(5000-(progressbar*50));
                    homer.animate().rotation(1080f).setDuration(5000 - (progressbar*50));
                    bart.animate().scaleX(1f).setDuration(5000 - (progressbar * 50));
                    bart.animate().scaleY(1f).setDuration(5000 - (progressbar * 50));
                    homer.animate().scaleX(0f).setDuration(5000 - (progressbar*50));
                    homer.animate().scaleY(0f).setDuration(5000 - (progressbar*50));
                    break;
                }
                case 3: {
                    bart.animate().translationX(0l).setDuration(5000-(progressbar*50));
                    homer.animate().translationX(-1000l).setDuration(5000-(progressbar*50));
                    break;
                }
            }

        }
    }
}

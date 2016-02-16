package com.fyildirim.buttercheeseeggs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int current = 2;
    int[] game = new int[9];
    int[][] winList = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6},
    };

    FrameLayout endscreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        endscreen = (FrameLayout) findViewById(R.id.swag);
        for(int i = 0; i < 9; i++) {
            game[i] = 0;
        }
    }

    public void speel(View view) {
        ImageView image = (ImageView)(view);
        int curindex = Integer.parseInt(image.getTag().toString());
        if(checkWinner() == 0) {
            if (game[curindex] == 0) {
                if (current == 1) {
                    current = 2;
                } else {
                    current = 1;
                }
                game[curindex] = 1;
                animate(image, Integer.parseInt(image.getTag().toString()));
            }
        }
    }

    private void animate(ImageView image, int index) {
        image.setAlpha(1f);
        image.setTranslationX(-200);
        image.setTranslationY(-1000);

        if (current == 1) {
            game[index] = 1;
            image.setImageResource(R.drawable.kruisje);
        }
        else if (current == 2) {
            game[index] = 2;
            image.setImageResource(R.drawable.rondje);
        }
        if(checkWinner() != 0) {
            TextView tekst = (TextView) findViewById(R.id.endtekst);
            tekst.setText("Player " + checkWinner() + " wins!");
            endscreen.setVisibility(View.VISIBLE);
        } else {
            int count = 0;
            for(int i = 0; i < 9; i++) {
                if(game[i] != 0) count++;
            }
            if(count == 9) {
                TextView tekst = (TextView) findViewById(R.id.endtekst);
                tekst.setText("It's a tie!");
                endscreen.setVisibility(View.VISIBLE);
            }
        }
        image.animate().translationX(0).translationY(0).setDuration(150);
    }

    private int checkWinner() {
        int winner = 0;
        for(int[] list : winList) {
            int count = 0;
            for(int i : list) {
                if(game[i] == current) {
                    count++;
                }
            }
            if(count == 3) {
                winner = current;
                break;
            }
        }
        return winner;
    }

    public void reset(View view) {
        for(int i = 0; i < game.length; i++) {
            game[i] = 0;
        }
        current = 2;
        TableLayout tableLayout = (TableLayout)(findViewById(R.id.tableLayout));
        for (int iRow = 0; iRow < 3; iRow++) {
            TableRow tableRow = (TableRow)(tableLayout.getChildAt(iRow));
            for (int iView = 0; iView < 3; iView++) {
                ImageView imageView = (ImageView)(tableRow.getChildAt(iView));
                imageView.setImageResource(0);
            }
        }
        endscreen.setVisibility(View.GONE);
    }

}

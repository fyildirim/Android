package com.fyildirim.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    //dit is een test comment van soufyane
    EditText input;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
    }

    public void euroToDollar(View view) {
        // 1 euro = 1.111532 dollar
        // 1 dollar = 0.899659 euro
        try {
            double uitkomst = Double.parseDouble(input.getText().toString()) * 1.108625;
            System.out.println((double)((int)(uitkomst*100))/100+
                    "  (double)((int)(uitkomst*100))/100");
            if ((double)((int)(uitkomst*100))/100 == (int)(uitkomst))
                output.setText(String.format("$ %.0f,-", uitkomst));
            else output.setText(String.format("$ %.2f", uitkomst));
        }
        catch (NumberFormatException e) {output.setText("INVALID INPUT");}
    }

    public void dollarToEuro(View view) {
        // 1 euro = 1.111532 dollar
        // 1 dollar = 0.899659 euro
        try {
            double uitkomst = Double.parseDouble(input.getText().toString()) / 1.108625;
            System.out.println((double)((int)(uitkomst*100))/100+
                    "  (double)((int)(uitkomst*100))/100");
            if ((double)((int)(uitkomst*100))/100 == (int)(uitkomst)) output.setText(String.format("€ %.0f,-", uitkomst));
            else output.setText(String.format("€ %.2f", uitkomst));
        }
        catch (NumberFormatException e) {output.setText("INVALID INPUT");}
    }
}

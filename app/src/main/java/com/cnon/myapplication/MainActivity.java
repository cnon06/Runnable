package com.cnon.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    Handler handler;
    Runnable runnable;
    Button Start;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        Start = findViewById(R.id.Start);

    }


    public void start(View view)
    {

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

         i++;
         text.setText(i+"");
       //  Log.e("Output: ",i+"");
         handler.postDelayed(runnable,1000);

            }
        };

        handler.post(runnable);
        Start.setEnabled(false);


    }

    public void pause(View view)
    {
        handler.removeCallbacks(runnable);
        Start.setEnabled(true);

    }

    public void stop(View view)
    {
        handler.removeCallbacks(runnable);
        Start.setEnabled(true);
        i=0;
        text.setText("0");

    }

}
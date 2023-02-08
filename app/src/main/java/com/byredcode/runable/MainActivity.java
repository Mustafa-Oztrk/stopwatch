package com.byredcode.runable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Handler handler;
    Runnable runnable;
    int Number;
    Button button;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button= findViewById(R.id.button);

    }

    public void start(View view){

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time :" +Number);
                Number++;
                textView.setText("Time :" +Number);
                handler.postDelayed(runnable, 1000);

            }
        };
        handler.post(runnable);
        button.setEnabled(false);

    }




    public void pause(View view){
        button.setEnabled(true);
        handler.removeCallbacks(runnable);
        Number = Number;
        textView.setText("Time : " + Number);
    }



    public void  stop (View view){
        button.setEnabled(true);
        handler.removeCallbacks(runnable);
        Number = 0;

        textView.setText("Time : " +Number );
    }

}
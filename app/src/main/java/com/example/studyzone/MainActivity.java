package com.example.studyzone;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setContentView(R.layout.activity_main);
        //This gives that 3 second delay when you first open it
        new Timer().schedule(new TimerTask() {
            public void run() {
                startActivity(new Intent(MainActivity.this, Statistics.class));
                finish();

            }
        }, 3000);
    }
}

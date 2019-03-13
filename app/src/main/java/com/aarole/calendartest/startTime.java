package com.aarole.calendartest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public class startTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_time);

        Intent in = getIntent();
        Bundle b = in.getExtras();
        final int year = (int) b.get("year");
        final int month = (int) b.get("month");
        final int date = (int) b.get("date");
        final String day = (String) b.get("day");

        final TimePicker timePicker = findViewById(R.id.startTime);

        findViewById(R.id.confBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int hour = timePicker.getHour();
                final int minute = timePicker.getMinute();
                final String time = Integer.toString(hour) + ":" + Integer.toString(minute);

                Intent intent = new Intent(startTime.this, MainActivity.class);
                intent.putExtra("time", time);
                intent.putExtra("hour", hour);
                intent.putExtra("minute", minute);
                intent.putExtra("year", year);
                intent.putExtra("month", month);
                intent.putExtra("date", date);
                intent.putExtra("day", day);
                startActivity(intent);
            }
        });

    }
}

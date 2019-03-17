package com.aarole.calendartest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;

public class endDate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_date);

        final DatePicker datePicker = findViewById(R.id.endDatePicker);

        findViewById(R.id.confBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = datePicker.getYear();
                int month = datePicker.getMonth();
                int date = datePicker.getDayOfMonth();

                String day = Integer.toString(year) + "/" + Integer.toString(month+1) + "/" + Integer.toString(date);

                Intent intent = new Intent(endDate.this, startTime.class);
                intent.putExtra("year", year);
                intent.putExtra("month", month);
                intent.putExtra("date", date);
                intent.putExtra("day", day);
                startActivity(intent);
                finish();
            }
        });
    }
}

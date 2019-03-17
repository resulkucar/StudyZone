package com.aarole.calendartest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

//    public static ArrayList<String> getReminders() {
//        return reminders;
//    }

    public static ArrayList<String> getReminders() {
        return reminders;
    }

    public static ArrayList<Long> getBeginTime() {
        return beginTime;
    }

    public static ArrayList<Long> getEndTime() {
        return endTime;
    }

    private static ArrayList<String> reminders = new ArrayList<>();
    private static ArrayList<Long> beginTime = new ArrayList<>();
    private static ArrayList<Long> endTime = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent in = getIntent();
        Bundle b = in.getExtras();
        String startTime = (String) b.get("time");
        final int hour = (int) b.get("hour");
        final int minute = (int) b.get("minute");
        final int year = (int) b.get("year");
        final int month = (int) b.get("month");
        final int date = (int) b.get("date");
        String endDay = (String) b.get("day");


        final EditText edit = findViewById(R.id.message);

        TextView time = findViewById(R.id.startTime);
        TextView day = findViewById(R.id.endDate);

        time.setText(startTime);
        day.setText(endDay);

        findViewById(R.id.setBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = edit.getText().toString();
                reminders.add(title);
                remIO.writeData(reminders, getApplicationContext());

                Calendar calendar = Calendar.getInstance();

                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.HOUR_OF_DAY, hour);
                calendar1.set(Calendar.MINUTE, minute);
                calendar1.set(Calendar.SECOND, 0);
                beginTime.add(calendar1.getTimeInMillis());
                begIO.writeData(beginTime, getApplicationContext());

                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(Calendar.YEAR, year);
                calendar2.set(Calendar.MONTH, month);
                calendar2.set(Calendar.DAY_OF_MONTH, date);
                calendar2.set(Calendar.HOUR_OF_DAY, hour);
                calendar2.set(Calendar.MINUTE, minute);
                calendar2.set(Calendar.SECOND, 0);
                endTime.add(calendar2.getTimeInMillis());
                endIO.writeData(endTime, getApplicationContext());


                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra("beginTime", calendar1.getTimeInMillis());
                intent.putExtra("allDay", false);
                //intent.putExtra("rrule", "FREQ=WEEKLY"); Google Calendar is currently causing errors when setting recurrence rule.
                intent.putExtra("title", title);
                intent.putExtra("endTime", calendar2.getTimeInMillis());
                startActivity(intent);
                finish();
            }
        });

    }
}

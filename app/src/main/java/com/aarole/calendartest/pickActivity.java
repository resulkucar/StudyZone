package com.aarole.calendartest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class pickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick);

        findViewById(R.id.addBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pickActivity.this, endDate.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.removeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pickActivity.this, remList.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.musicBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pickActivity.this, playlistPicker.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.homeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pickActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.listBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pickActivity.this, todo.class);
                startActivity(intent);
            }
        });
    }
}

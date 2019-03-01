package com.aarole.studyzonespotify;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button user = findViewById(R.id.myplaylistsBtn);
        Button random = findViewById(R.id.randomBtn);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri u = Uri.parse("https://open.spotify.com/collection/playlists");
                Intent intent = new Intent(Intent.ACTION_VIEW, u);
                startActivity(intent);
            }
        });

        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random = (int)(Math.random()*4);
                Uri r1 = Uri.parse("https://open.spotify.com/playlist/2jArGkAqIWi2Sx8Hypa31p");
                Uri r2 = Uri.parse("https://open.spotify.com/playlist/7L5cshmVSw9v0X0mZIn78U");
                Uri r3 = Uri.parse("https://open.spotify.com/playlist/37nHJKXeTOgQhwZXvRtGfm");
                Uri r4 = Uri.parse("https://open.spotify.com/playlist/2amhJhphcPln6Ybsjh6IYH");

                Uri[] r = {r1, r2, r3, r4};
                Intent intent = new Intent(Intent.ACTION_VIEW, r[random]);
                startActivity(intent);
            }
        });
    }
}

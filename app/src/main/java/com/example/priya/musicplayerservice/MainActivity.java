package com.example.priya.musicplayerservice;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button start,stop;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button)findViewById(R.id.play);
        stop = (Button)findViewById(R.id.stop);

        // Called when a button is clicked
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Bind to Service
                startService(new Intent(getApplicationContext(),MyService.class));
                startService(new Intent(MainActivity.this, NotificationService.class));

            }
        });

        // Called when a button is clicked
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Unbind from the service

                stopService(new Intent(getApplicationContext(),MyService.class));

            }
        });
    }
}

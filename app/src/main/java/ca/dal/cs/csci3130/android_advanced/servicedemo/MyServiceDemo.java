package ca.dal.cs.csci3130.android_advanced.servicedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import ca.dal.cs.csci3130.android_advanced.R;

public class MyServiceDemo extends AppCompatActivity {

    public static String WELCOME_MESSAGE = "WELCOME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service_demo2);
        Button startButton = (Button) findViewById(R.id.serviceStartButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMusicService(view);
            }
        });

        Button stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopMusic(view);
            }
        });


        Button moveButton = (Button) findViewById(R.id.moveButton);
        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move2Other();
            }
        });
    }

    protected void startMusicService(View view) {
        Intent musicServiceIntent = new Intent(getBaseContext(), MusicService.class);
        startService(musicServiceIntent);
    }

    protected void move2Other() {
        Intent otherWindow = new Intent(getBaseContext(), OtherServiceActivity.class);
        otherWindow.putExtra(WELCOME_MESSAGE, "Welcome to the second windows!");
        startActivity(otherWindow);
    }

    protected void stopMusic(View view) {
        Intent musicStopService = new Intent(getBaseContext(), MusicService.class);
        stopService(musicStopService);
    }
}
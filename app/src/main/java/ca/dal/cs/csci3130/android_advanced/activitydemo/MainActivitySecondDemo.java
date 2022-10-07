package ca.dal.cs.csci3130.android_advanced.activitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ca.dal.cs.csci3130.android_advanced.R;
import ca.dal.cs.csci3130.android_advanced.facebook.FacebookActivity;
import ca.dal.cs.csci3130.android_advanced.googlemap.GoogleMapsActivity;
import ca.dal.cs.csci3130.android_advanced.notificationdemo.NotificationDemoActivity;
import ca.dal.cs.csci3130.android_advanced.rating.RatingActivity;
import ca.dal.cs.csci3130.android_advanced.recycler.RecyclerActivity;

public class MainActivitySecondDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second_demo);


        Button gmapButton = findViewById(R.id.gmapButton);
        gmapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gmapIntent = new Intent(getBaseContext(), GoogleMapsActivity.class);
                startActivity(gmapIntent);
            }
        });

        Button recyclerButton = findViewById(R.id.recyclerButton);
        recyclerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent recyclerIntent = new Intent(getBaseContext(), RecyclerActivity.class);
                startActivity(recyclerIntent);
            }
        });

        Button notificationButton = findViewById(R.id.notificationButton);
        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notifyIntent = new Intent(getBaseContext(), NotificationDemoActivity.class);
                startActivity(notifyIntent);
            }
        });

        Button fbGraphAPI = findViewById(R.id.fbGraphAPI);
        fbGraphAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fbgraphIntent = new Intent(getBaseContext(), FacebookActivity.class);
                startActivity(fbgraphIntent);
            }
        });

        Button rating = findViewById(R.id.rating);
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ratingIntent = new Intent(getBaseContext(), RatingActivity.class);
                startActivity(ratingIntent);
            }
        });

        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(getBaseContext(), MainActivityDemo.class);
                startActivity(homeIntent);
            }
        });


    }
}
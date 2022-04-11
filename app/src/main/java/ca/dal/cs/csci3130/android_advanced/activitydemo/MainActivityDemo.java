package ca.dal.cs.csci3130.android_advanced.activitydemo;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ca.dal.cs.csci3130.android_advanced.R;
import ca.dal.cs.csci3130.android_advanced.breceiver.MyReceiverDemo;
import ca.dal.cs.csci3130.android_advanced.dragndrop.DragnDropDemo;
import ca.dal.cs.csci3130.android_advanced.facebook.FacebookActivity;
import ca.dal.cs.csci3130.android_advanced.fragmentdemo.FragmentMainActivity;
import ca.dal.cs.csci3130.android_advanced.googlemap.GoogleMapsActivity;
import ca.dal.cs.csci3130.android_advanced.intentdemo.IntentMainActivity;
import ca.dal.cs.csci3130.android_advanced.location.GPSDemo;
import ca.dal.cs.csci3130.android_advanced.notificationdemo.NotificationDemoActivity;
import ca.dal.cs.csci3130.android_advanced.rating.RatingActivity;
import ca.dal.cs.csci3130.android_advanced.recycler.RecyclerActivity;
import ca.dal.cs.csci3130.android_advanced.servicedemo.MyServiceDemo;

public class MainActivityDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_demo);
        Button pressButton = (Button) findViewById(R.id.pressButton);
        pressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "I am pressed", Toast.LENGTH_SHORT).show();
                showAlert("I am pressed");
            }
        });

        Button breciver = findViewById(R.id.broadcastRecButton);
        breciver.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent breceiverIntent = new Intent(getBaseContext(), MyReceiverDemo.class);
                startActivity(breceiverIntent);
            }
        });

        Button serviceButton=findViewById(R.id.serviceButton);
        serviceButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent serviceIntent=new Intent(getBaseContext(), MyServiceDemo.class);
                startActivity(serviceIntent);
            }
        });

        Button dragndropButton=findViewById(R.id.dragNDropButton);
        dragndropButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent dragIntent=new Intent(getBaseContext(), DragnDropDemo.class);
                startActivity(dragIntent);
            }
        });

        Button fragmentButton=findViewById(R.id.fragmentButton);
        fragmentButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent fragmentIntent=new Intent(getBaseContext(), FragmentMainActivity.class);
                startActivity(fragmentIntent);
            }
        });

        Button intentButton=findViewById(R.id.intentButton);
        intentButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intentButton=new Intent(getBaseContext(), IntentMainActivity.class);
                startActivity(intentButton);
            }
        });

        Button locationButton=findViewById(R.id.locationButton);
        locationButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent locationIntent=new Intent(getBaseContext(), GPSDemo.class);
                startActivity(locationIntent);
            }
        });

        Button gmapButton=findViewById(R.id.gmapButton);
        gmapButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent gmapIntent=new Intent(getBaseContext(), GoogleMapsActivity.class);
                startActivity(gmapIntent);
            }
        });

        Button recyclerButton=findViewById(R.id.recyclerButton);
        recyclerButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent recyclerIntent=new Intent(getBaseContext(), RecyclerActivity.class);
                startActivity(recyclerIntent);
            }
        });

        Button notificationButton=findViewById(R.id.notificationButton);
        notificationButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent notifyIntent=new Intent(getBaseContext(), NotificationDemoActivity.class);
                startActivity(notifyIntent);
            }
        });

        Button fbGraphAPI=findViewById(R.id.fbGraphAPI);
        fbGraphAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fbgraphIntent=new Intent(getBaseContext(), FacebookActivity.class);
                startActivity(fbgraphIntent);
            }
        });

        Button rating=findViewById(R.id.rating);
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ratingIntent=new Intent(getBaseContext(), RatingActivity.class);
                startActivity(ratingIntent);
            }
        });








    }

    protected void showAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle("Information!");
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}
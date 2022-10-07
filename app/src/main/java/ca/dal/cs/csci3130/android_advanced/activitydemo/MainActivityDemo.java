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
import ca.dal.cs.csci3130.android_advanced.fragmentdemo.FragmentMainActivity;
import ca.dal.cs.csci3130.android_advanced.intentdemo.IntentMainActivity;
import ca.dal.cs.csci3130.android_advanced.location.GPSDemo;
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

        Button serviceButton = findViewById(R.id.serviceButton);
        serviceButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent serviceIntent = new Intent(getBaseContext(), MyServiceDemo.class);
                startActivity(serviceIntent);
            }
        });

        Button dragndropButton = findViewById(R.id.dragNDropButton);
        dragndropButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent dragIntent = new Intent(getBaseContext(), DragnDropDemo.class);
                startActivity(dragIntent);
            }
        });

        Button fragmentButton = findViewById(R.id.fragmentButton);
        fragmentButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent fragmentIntent = new Intent(getBaseContext(), FragmentMainActivity.class);
                startActivity(fragmentIntent);
            }
        });

        Button intentButton = findViewById(R.id.intentButton);
        intentButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intentButton = new Intent(getBaseContext(), IntentMainActivity.class);
                startActivity(intentButton);
            }
        });

        Button locationButton = findViewById(R.id.locationButton);
        locationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent locationIntent = new Intent(getBaseContext(), GPSDemo.class);
                startActivity(locationIntent);
            }
        });

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent nextPageIntent = new Intent(getBaseContext(), MainActivitySecondDemo.class);
                startActivity(nextPageIntent);
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
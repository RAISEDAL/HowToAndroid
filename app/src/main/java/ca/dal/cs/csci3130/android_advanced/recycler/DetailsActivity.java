package ca.dal.cs.csci3130.android_advanced.recycler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ca.dal.cs.csci3130.android_advanced.R;
import ca.dal.cs.csci3130.android_advanced.googlemap.GoogleMapsActivity;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent sentItem = getIntent();
        String item = sentItem.getStringExtra("selectedItem");
        TextView statusLabel = findViewById(R.id.statusLabel);
        String itemLocation = getItemLocation(item);
        statusLabel.setText("Location: " + itemLocation);

        ImageButton mapButton = findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String locCoord = getLocationCoordinate(itemLocation);
                Intent mapIntent = new Intent(getBaseContext(), GoogleMapsActivity.class);
                mapIntent.putExtra("city", itemLocation);
                mapIntent.putExtra("taskLocation", locCoord);
                startActivity(mapIntent);
            }
        });
    }

    protected String getLocationCoordinate(String itemLocation) {
        SharedPreferences sharedPreferences = getSharedPreferences(RecyclerActivity.MY_PREFS, Context.MODE_PRIVATE);
        return sharedPreferences.getString(itemLocation, null);
    }

    protected String getItemLocation(String item) {
        SharedPreferences sharedPreferences = getSharedPreferences(RecyclerActivity.MY_PREFS, Context.MODE_PRIVATE);
        return sharedPreferences.getString(item, null);
    }
}
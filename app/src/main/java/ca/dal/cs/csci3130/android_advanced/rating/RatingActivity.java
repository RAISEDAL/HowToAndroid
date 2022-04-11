package ca.dal.cs.csci3130.android_advanced.rating;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ca.dal.cs.csci3130.android_advanced.R;

public class RatingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        RatingBar ratingBar=findViewById(R.id.ratingBar);
        Button submitButton=findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                float rating=ratingBar.getRating();
                Toast.makeText(getBaseContext(),Float.toString(rating), Toast.LENGTH_LONG).show();
            }
        });
    }
}
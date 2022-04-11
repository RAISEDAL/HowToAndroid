package ca.dal.cs.csci3130.android_advanced.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import ca.dal.cs.csci3130.android_advanced.R;

public class IntentTargetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_target);
        this.captureIntent();
    }

    protected void captureIntent() {
        try {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            String name = extras.getString(IntentMainActivity.NAME);
            String csid = extras.getString(IntentMainActivity.CSID);
            Toast.makeText(getBaseContext(), name + " " + csid, Toast.LENGTH_LONG).show();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

}
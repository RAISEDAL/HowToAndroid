package ca.dal.cs.csci3130.android_advanced.notificationdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import ca.dal.cs.csci3130.android_advanced.R;

public class NotificationView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Intent intent=getIntent();
        String message=intent.getStringExtra(NotificationDemoActivity.MESSAGE);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
package ca.dal.cs.csci3130.android_advanced.breceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Intent detected!" + intent.getAction(),
                Toast.LENGTH_LONG).show();
    }
}

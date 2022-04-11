package ca.dal.cs.csci3130.android_advanced.breceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ca.dal.cs.csci3130.android_advanced.R;

public class MyReceiverDemo extends AppCompatActivity {

    public static String CUSTOM_INTENT = "com.intent.CUSTOM_INTENT";
    IntentFilter filter;
    private BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_receiver_demo);

        Button bcastButton = (Button) findViewById(R.id.bcastButton);
        bcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(CUSTOM_INTENT);
                sendBroadcast(intent);
                Toast.makeText(getBaseContext(), "Sent the broadcast",
                        Toast.LENGTH_SHORT).show();
            }
        });
        receiver = getReceiver();
        filter=getFilter();
        registerReceiverAndFilter(receiver,filter);
    }

    protected void registerReceiverAndFilter(BroadcastReceiver receiver, IntentFilter filter){
        registerReceiver(receiver, filter);
    }

    protected IntentFilter getFilter(){
        filter = new IntentFilter();
        filter.addAction(CUSTOM_INTENT);
        return  filter;
    }

    protected BroadcastReceiver getReceiver() {
        return new MyBroadcastReceiver();
    }

    protected BroadcastReceiver getInlineReceiver() {
        return new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                Toast.makeText(getBaseContext(), "Intent detected :" +
                        action, Toast.LENGTH_SHORT).show();
            }
        };
    }


}
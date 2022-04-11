package ca.dal.cs.csci3130.android_advanced.notificationdemo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import ca.dal.cs.csci3130.android_advanced.R;

public class NotificationDemoActivity extends AppCompatActivity {

    public static String MESSAGE = "ca.dal.cs.GOOD_NIGHT";
    String channelID = "Notification";
    int notificationID = 0;
    int selectedButtonID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_demo);

        Button notifyButton = (Button) findViewById(R.id.notifyButton);
        notifyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (selectedButtonID) {
                    case R.id.basic:
                        addNotificationBasic();
                        break;

                    case R.id.callback:
                        addNotificationWithCallback();
                        break;

                    case R.id.inbox:
                        addNotificationInboxStyle();
                        break;
                }
            }
        });

        RadioGroup notifyOptions = findViewById(R.id.notifyOptionList);
        notifyOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                selectedButtonID = radioGroup.getCheckedRadioButtonId();
            }
        });
    }


    protected void addNotificationBasic() {
        Notification.Builder builder = new Notification.Builder(this, channelID);
        builder.setSmallIcon(R.drawable.information);
        builder.setContentTitle("Bed time!");
        builder.setContentText("Must go to bed at 2:00 AM");
        builder.setPriority(Notification.PRIORITY_DEFAULT);

        Intent nIntent = new Intent(this, NotificationDemoActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, nIntent, 0);
        builder.setContentIntent(pIntent);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(notificationID, builder.build());
    }

    protected void addNotificationWithCallback() {
        Notification.Builder builder = new Notification.Builder(this, channelID);
        builder.setSmallIcon(R.drawable.information);
        builder.setContentTitle("Bed time!");
        builder.setContentText("Must go to bed at 2:00 AM");
        builder.setPriority(Notification.PRIORITY_DEFAULT);

        Intent nIntent = new Intent(this, NotificationView.class);
        nIntent.putExtra(MESSAGE, "Detailed message: Must go to bed at 2:00 AM");
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, nIntent, 0);
        builder.setContentIntent(pIntent);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(notificationID, builder.build());
    }

    protected void addNotificationInboxStyle() {
        Notification.Builder builder = new Notification.Builder(this, channelID);
        builder.setSmallIcon(R.drawable.information);
        builder.setContentTitle("New Message!");
        builder.setContentText("You have received a new message.");
        builder.setTicker("New Message Alert!");
        builder.setPriority(Notification.PRIORITY_DEFAULT);

        Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
        String[] events = new String[6];
        events[0] = new String("Good morning!");
        events[1] = new String("Have a nice breakfast.");
        events[2] = new String("Time to go to office.");
        events[3] = new String("Have a great afternoon!");
        events[4] = new String("Good evening!");
        events[5] = new String("Good night, sweet dreams!");
        inboxStyle.setBigContentTitle("Daily Schedule");

        for (String event : events) {
            inboxStyle.addLine(event);
        }

        builder.setStyle(inboxStyle);
        Intent notificationIntent = new Intent(this, NotificationDemoActivity.class);
        //notificationIntent.putExtra(MESSAGE,"Goodnight!");
        TaskStackBuilder taskStack = TaskStackBuilder.create(this);
        taskStack.addParentStack(NotificationView.class);
        taskStack.addNextIntent(notificationIntent);

        PendingIntent pendingIntent = taskStack.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(notificationID, builder.build());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void addNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelID);
        builder.setSmallIcon(R.drawable.info);
        builder.setContentTitle("Next meeting!");
        builder.setContentText("Attending Popi at 5:45PM");
        builder.setNumber(0);
        builder.setAutoCancel(false);
        builder.setPriority(NotificationCompat.PRIORITY_MAX);

        Intent notificationIntent = new Intent(this, NotificationView.class);
        notificationIntent.putExtra("message", "Hello there!");
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);

        manager.createNotificationChannel(new NotificationChannel(channelID, "Custom", NotificationManager.IMPORTANCE_HIGH));
        Notification note = builder.build();
        manager.notify(notificationID, note);
    }
}
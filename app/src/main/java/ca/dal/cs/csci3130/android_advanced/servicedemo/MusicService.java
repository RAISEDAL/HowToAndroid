package ca.dal.cs.csci3130.android_advanced.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;
import ca.dal.cs.csci3130.android_advanced.R;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;

    public MusicService() {
        //default constructor
    }

    @Override
    public void onCreate(){
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.beat);
        mediaPlayer.setLooping(true);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        Toast.makeText(this, "Music started!", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        Toast.makeText(this, "Music stopped!", Toast.LENGTH_LONG).show();
    }
}
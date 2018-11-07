package com.wedapp.sud.myapp2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class PlayAudio extends Service {
    MediaPlayer mp;
    public PlayAudio() {
    }
    @Override
    public void onCreate() {
        mp = MediaPlayer.create(this, R.raw.sound);
        mp.setLooping(true);
        super.onCreate();
    }
    public void onStart(Intent intent, int startid) {
        mp.start();
    }
    public void onDestroy() {
        mp.stop();
        mp.reset();
        mp = null;
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
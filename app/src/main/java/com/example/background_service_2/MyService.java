package com.example.background_service_2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;

import java.util.concurrent.atomic.AtomicBoolean;

import androidx.annotation.Nullable;

public class MyService extends Service {

  Handler handler;
    MediaPlayer player;
    public final AtomicBoolean running = new AtomicBoolean(false);
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //new Thread(new ControlSubThread(5000)).start();
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.start();
        return android.app.Service.START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
       // running.set(false);
        //Intent intent= new Intent(this,Recivers.class);
        //sendBroadcast(intent);
        player.stop();
    }

    public class ControlSubThread implements Runnable {

        private Thread worker;

        private int interval;

        public ControlSubThread(int sleepInterval) {
            interval = sleepInterval;


        }
        public ControlSubThread() {}



        public void run() {
            running.set(true);
            int i=0;
            while (running.get()) {
                try {
                    i++;
                    Thread.sleep(interval);
                    System.out.println("b");



                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    System.out.println("Thread was interrupted, Failed to complete operation");
                }
                // do something here
            }
        }



    }

}

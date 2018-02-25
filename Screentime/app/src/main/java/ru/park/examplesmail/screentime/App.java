package ru.park.examplesmail.screentime;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import java.util.Date;


public class App extends Application {

    private long new_time = 0;
    private long last_time = 0;

    private final BroadcastReceiver screenReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(final Context context, final Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if (Intent.ACTION_SCREEN_ON.equals(action)) {
                    Date date = new Date();
                    new_time = date.getTime();
                    long my_time = (new_time - last_time)/1000;
                    final Intent time_intent = new Intent(App.this, TimeActivity.class);
                    time_intent.putExtra(TimeActivity.TIME, my_time);
                    startActivity(time_intent);
                }
                if (Intent.ACTION_SCREEN_OFF.equals(action)) {
                    Date date = new Date();
                    last_time = date.getTime();
                }
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();

        final IntentFilter IF = new IntentFilter();
        IF.addAction(Intent.ACTION_SCREEN_ON);
        IF.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(screenReceiver, IF);
    }
}
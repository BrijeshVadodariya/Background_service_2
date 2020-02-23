package com.example.background_service_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Recivers extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context,MyService.class));
    }
}

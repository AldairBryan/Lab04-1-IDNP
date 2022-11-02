package com.example.lab04_1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("com.aplicacion1.message")){
            Log.i("INFO", intent.getStringExtra("app") );
            Toast.makeText(context, intent.getStringExtra("app"), Toast.LENGTH_SHORT).show();
        }else if (intent.getAction().equals("com.aplicacion2.message")){
            Log.i("INFO", intent.getStringExtra("app"));
            Toast.makeText(context, intent.getStringExtra("app"), Toast.LENGTH_SHORT).show();
        }
    }
}
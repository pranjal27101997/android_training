package com.example.myapplication_broadcast_recieve;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

class BatteryReciever extends BroadcastReceiver {
    TextView tv;
    BatteryReciever(TextView tv){

        this.tv=tv;
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        int defaultValue;
        int percentage=intent.getIntExtra("level",0);
        if(percentage!=0){
            tv.setText(percentage+"%");

    }
}}


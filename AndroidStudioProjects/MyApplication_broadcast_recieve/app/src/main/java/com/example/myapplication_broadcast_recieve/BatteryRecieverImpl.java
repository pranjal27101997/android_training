package com.example.myapplication_broadcast_recieve;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class BatteryRecieverImpl extends BatteryReciever {
    BatteryRecieverImpl(TextView tv) {
        super(tv);
    }

    @Override
    public void onReceive(Context context, Intent intent) {

    }
}

package com.example.myapplication_broadcast_recieve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//    Textview tv;
BatteryReciever b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv=findViewById(R.id.tv);
        b1=new BatteryReciever(tv);
        registerReceiver(b1, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(b1);

    }
}

//ye event deliver karta hai system ko like battery msg ,incoming call....
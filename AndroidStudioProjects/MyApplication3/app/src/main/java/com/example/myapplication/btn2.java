package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class btn2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn2);
        TextView t2=findViewById(R.id.t2);
        Intent intent=getIntent();
        String message = intent.getStringExtra("n2");
        t2.setText("you are succesfully logout from your account  !!" +message);



    }
}
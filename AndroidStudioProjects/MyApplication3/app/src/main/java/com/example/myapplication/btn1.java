package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class btn1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn1);

        TextView t1=findViewById(R.id.t1);
        Button back=findViewById(R.id.back);

        Intent intent=getIntent();
        String message = intent.getStringExtra("n");
        t1.setText("your form is submitted "+message);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(btn1.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }


}
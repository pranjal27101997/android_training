package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "v";
    Button b1,b2;
        EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        e1=findViewById(R.id.e1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=e1.getText().toString();
                Intent i = new Intent(getApplicationContext(), btn1.class);
                i.putExtra("n",s);
                startActivity(i);           }
                                                        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s2=e1.getText().toString();
                Intent i = new Intent(getApplicationContext(), btn2.class);
                i.putExtra("n2",s2);
                startActivity(i);           }
        });
                                                         }


    }

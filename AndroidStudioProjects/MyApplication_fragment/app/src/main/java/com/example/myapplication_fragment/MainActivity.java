package com.example.myapplication_fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {
    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button1);

        b2=findViewById(R.id.button2);

    }
    public void selectFrag(View view)
    {

        if(view==b1)
        {
           FragmentOne fr = new FragmentOne();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment, fr);
            ft.commit();

        }
        if(view==b2)
        {
            FragmentTwo fr = new FragmentTwo();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment, fr);
            ft.commit();

        }

    }

}
package com.example.recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL, false));
        list.setAdapter(new HorizontalAdapter(new  String[]{"Android","C++","c","python","java","java script","php","yii","html","css","laravel","jquery","eng","hindi","science","math"}));
    }
}
package com.example.room_database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btAdd,btReset;
    RecyclerView recyclerView;



    List<MainData> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RoomDB database;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.edit_text);
        btAdd=findViewById(R.id.bt_add);

        btReset=findViewById(R.id.bt_reset);
        recyclerView=findViewById(R.id.recycler_view);

        //initialize db

        database=RoomDB.getInstance(this);
        //store db value
        dataList=database.mainDao().getAll();

        //layout mg iniatialize kro

        linearLayoutManager=new LinearLayoutManager(this);
        //set layout mg

        recyclerView.setLayoutManager(linearLayoutManager);

        //adapter initialize kro

        adapter=new MainAdapter(MainActivity.this,dataList);
        recyclerView.setAdapter(adapter);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sText=editText.getText().toString().trim();
                if(!sText.equals("")){

                    MainData data=new MainData();
                    data.setText(sText);
                    database.mainDao().insert(data);
                    editText.setText("");
//notify when data is inserted
                    dataList.clear();
                    dataList.addAll(database.mainDao().getAll());
                    adapter.notifyDataSetChanged();

                }
            }
        });
        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //delete all

                database.mainDao().reset(dataList);
                dataList.clear();
                dataList.addAll(database.mainDao().getAll());
                adapter.notifyDataSetChanged();
            }
        });
    }
}
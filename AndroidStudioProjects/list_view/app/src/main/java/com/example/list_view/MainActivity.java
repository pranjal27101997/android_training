package com.example.list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=(ListView)findViewById(R.id.listview);

        final ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("india");
        arrayList.add("pak");
        arrayList.add("corona");
        arrayList.add("kim jong un");
        arrayList.add("america");
        arrayList.add("usa");
        arrayList.add("japan");
        arrayList.add("kim");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent , View view,int position , long id){
                Toast.makeText(getApplicationContext(),"country: "+arrayList.get(position),Toast.LENGTH_SHORT).show();
            }

        });

    }
}
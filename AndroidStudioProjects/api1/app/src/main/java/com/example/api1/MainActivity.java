package com.example.api1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import okhttp3.OkHttpClient;
//import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ListView listView=findViewById(R.id.listView);
        TextView textView=findViewById(R.id.textView);


//        // Create a new object from HttpLoggingInterceptor
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        // Add Interceptor to HttpClient
//        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //ConverterFactory==converting JSON to Java objects, (GSON, Jackson..etc)
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Appl>> call = api.getAppls();

        call.enqueue(new Callback<List<Appl>>() {
            @Override
            public void onResponse(Call<List<Appl>> call, Response<List<Appl>> response) {

                //appl ki list milegi
                List<Appl> appl = response.body();

//                String[] applSubjects = new String[appl.size()];
//                for(Appl h:appl){
//
//
//                    Log.d("subject", h.getSubject());
//                    Log.d("name", h.getType());
//                    Log.d("name", h.getStats());
//
//                }
//
                String[] appls = new String[appl.size()];
                appls[0]=appl.get(0).getSubject();
                textView.setText(appls[0]);
//                for(int i=0;i<appls.size();i++){
//
//                    applSubjects[i]=appls.get(i).getSubject();
//
//                }
//                listView.setAdapter(
//                        new ArrayAdapter<String>(
//                                getApplicationContext(),
//                                android.R.layout.simple_list_item_1,
//                                applSubjects
//                        )
//                );

            }



            @Override
            public void onFailure(Call<List<Appl>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });
    }



}
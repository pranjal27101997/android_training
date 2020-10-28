package com.example.map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;

import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {
    Button loc1;
    TextView textView;
    private static final String TAG = "MainActivity";
    int LOCATION_REQUEST_CODE = 1001;
    FusedLocationProviderClient fusedLocationProviderClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loc1 = findViewById(R.id.loc1);
        textView = findViewById(R.id.textView);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);


        loc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "GET Location", Toast.LENGTH_SHORT).show();
//                onLocationChanged(location);

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                    getLastLocation();
                } else {

                    askPermission();
                }


            }
        });

    }

    private void getLastLocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Task<Location> locationTask = fusedLocationProviderClient.getLastLocation();
        locationTask.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null)
                {
                    Log.d(TAG, "onSuccess: "+location.toString());
                    Log.d(TAG, "onSuccess: "+location.getLatitude());
                    Log.d(TAG, "onSuccess: "+location.getLongitude());
                    textView.setText("Longitude "+location.getLongitude()+'\n'+"Latitude"+location.getLatitude());
                }
                else
                {
                    Log.d(TAG, "onSuccess: location was nll...");
                }

            }
        });
        locationTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e(TAG, "onFailure: "+e.getLocalizedMessage() );
            }
        });


    }
    private void askPermission()
    {
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION))
            {
                Log.d(TAG, "askPermission: you shoule show an alert dialog ");
                ActivityCompat.requestPermissions(this,new String []{Manifest.permission.ACCESS_FINE_LOCATION},LOCATION_REQUEST_CODE);
            }
            else
            {
                ActivityCompat.requestPermissions(this,new String []{Manifest.permission.ACCESS_FINE_LOCATION},LOCATION_REQUEST_CODE);

            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==LOCATION_REQUEST_CODE)
        {
            if(grantResults.length >0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                //permission is granted
                getLastLocation();
            }
            else{
                //permission is not granted
            }
        }
    }
}
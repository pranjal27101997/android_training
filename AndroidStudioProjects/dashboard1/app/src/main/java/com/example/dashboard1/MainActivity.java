package com.example.dashboard1;

import android.content.Intent;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private static final int pic_id = 123;

//    Button camera_open_id;
//    ImageView click_image_id;

        private DrawerLayout drawer;
        private Toolbar toolbar;
        private NavigationView navigationView;
        private ActionBarDrawerToggle toggle;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

//            camera_open_id = (Button)findViewById(R.id.camera1);
//            click_image_id = (ImageView)findViewById(R.id.click1);
//
//            camera_open_id.setOnClickListener(new View.OnClickListener() {

//                @Override
//                public void onClick(View v)
//                {

                    // Create the camera_intent ACTION_IMAGE_CAPTURE
                    // it will open the camera for capture the image
//                    Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    // Start the activity with camera_intent,
                    // and request pic id
//                    startActivityForResult(camera_intent, pic_id);
//                }
//            });

            toolbar=findViewById(R.id.toolbar);
            drawer=findViewById(R.id.drawer);
            navigationView=findViewById(R.id.navigation);
//
//           setSupportActionBar(toolbar);
            toggle =new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();


            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    drawer.closeDrawer(GravityCompat.START);
                    switch (item.getItemId()) {

                        case R.id.Home:
                            Toast.makeText(MainActivity.this, "HOME", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.brand:
                            Toast.makeText(MainActivity.this, Build.BRAND , Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.model_no:
                            Toast.makeText(MainActivity.this, Build.MANUFACTURER
                                    + " " + Build.MODEL , Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.battery:


                            Intent intent = new Intent();
                            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

                            float currentBatteryLevel = (level * 100) / (float) scale;


                            Toast.makeText(MainActivity.this, "Current battery level: " + Float.toString(currentBatteryLevel) + "%" , Toast.LENGTH_LONG).show();

                            break;

                        case R.id.android_version:
                            Toast.makeText(MainActivity.this, Build.VERSION.RELEASE
                                    + " " + Build.VERSION_CODES.class.getFields()[android.os.Build.VERSION.SDK_INT].getName(), Toast.LENGTH_SHORT).show();
                            break;

                    }
                    return true;
                }
            });




        }


    }

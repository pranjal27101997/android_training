package com.example.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final int pic_id = 123;

    Button camera_open_id;
    ImageView click_image_id;
//    ImageView imageView;
    Button button;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camera_open_id = (Button)findViewById(R.id.camera_button);
        click_image_id = (ImageView)findViewById(R.id.click_image);


        camera_open_id.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                // camera_intent ACTION_IMAGE_CAPTURE ===ye img capture krega camera khol k

                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

               //pic ki id lega
                startActivityForResult(camera_intent, pic_id);

            }
        });

        //nya

        button = (Button)findViewById(R.id.buttonLoadPicture);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }
    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            click_image_id.setImageURI(imageUri);
        }
        else if (requestCode == pic_id) {

            // bitmap ds hai img. store krne k lie
            Bitmap photo = (Bitmap) data.getExtras()
                    .get("data");

            // image view m pic dikhaiga.
            click_image_id.setImageBitmap(photo);
            MediaStore.Images.Media.insertImage(getContentResolver(), photo, "" , "");
        }
    }





    //ye img lega
//    protected void onActivityResult1(int requestCode, int resultCode, Intent data) {
//
//
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == pic_id) {
//
//            // bitmap ds hai img. store krne k lie
//            Bitmap photo = (Bitmap) data.getExtras()
//                    .get("data");
//
//            // image view m pic dikhaiga.
//            click_image_id.setImageBitmap(photo);
//            MediaStore.Images.Media.insertImage(getContentResolver(), photo, "" , "");
//        }
//    }


}

package com.example.picture;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.widget.ImageView;


public class MainActivity extends Activity {
    private ImageView imageView;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.imageView = (ImageView)this.findViewById(R.id.pictureDrawView);


        findViewById(R.id.makePicture).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
                dispatchTakePictureIntent();
                }
		});
        
        findViewById(R.id.drawPicture).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				pictureDraw1();
				
			}
		});

        findViewById(R.id.sendPicture).setOnClickListener((new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));

    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bitmap imageBitmap = (Bitmap)intent.getExtras().get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }

    private void pictureDraw1(){
    	Intent intent = new Intent(this, DrawONpicture.class);
		startActivity(intent);
    }
}

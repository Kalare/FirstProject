package com.example.picture;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	private Button doPhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        doPhoto = (Button)findViewById(R.id.makePicture);
        doPhoto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
			}
		});
        
        findViewById(R.id.drawPicture).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				pictureDraw();
				
			}
		});

    } 
    
    private void pictureDraw(){
    	Intent intent = new Intent(this, DrawONpicture.class);
		startActivity(intent);
    }
}

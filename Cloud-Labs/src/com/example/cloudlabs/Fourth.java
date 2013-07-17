package com.example.cloudlabs;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Fourth extends Activity {	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fourth);
		Intent next = getIntent(); 
		 SeekBar sk=(SeekBar)findViewById(R.id.seekBar1);
		 SeekBar sa=(SeekBar)findViewById(R.id.seekBar2);
		    final EditText tv=(EditText)findViewById(R.id.EditText1);
		    final EditText ta=(EditText)findViewById(R.id.EditText2);
		    sk.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

		                 public void onStopTrackingTouch(SeekBar arg0) {
		                       // TODO Auto-generated method stub

		                 }

		                 public void onStartTrackingTouch(SeekBar arg0) {
		                       // TODO Auto-generated method stub

		                 }

		                 public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
		                       // TODO Auto-generated method stub
		                       tv.setText("Temperature "+ arg1);


		                 }
		          });
		    sa.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

                public void onStopTrackingTouch(SeekBar arg0) {
                      // TODO Auto-generated method stub

                }

                public void onStartTrackingTouch(SeekBar arg0) {
                      // TODO Auto-generated method stub

                }

                public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                      // TODO Auto-generated method stub
                      ta.setText("Speed "+ arg1);


                }
         });
		}
 
	public void fifth(View view)
	{
		Intent fif = new Intent(this,Fifth.class);
		startActivity(fif);
	}
	            
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fourth, menu);
		return true;
	}

}

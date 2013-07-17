package com.example.cloudlabs;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class Fifth extends Activity {
	 protected static final int TIMER_RUNTIME = 10000; // in ms --> 10s
	 protected static final int TIMER2 = 10000;
	    protected boolean mbActive;
	    protected ProgressBar mProgressBar;
	    protected boolean mbActive2;
	    protected ProgressBar mProgressBar2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fifth);
		int i=0;
		for(i=0;i<=1;i++)
		{
		ImageView image = (ImageView) findViewById(R.id.imageView1);
		TranslateAnimation anim = new TranslateAnimation(-500, 1500, 50, 50);
		anim.setDuration(20000);
		anim.setFillAfter(true);
		image.startAnimation(anim);
		image.setImageResource(R.drawable.img1);
		}
		for(i=0;i<=1;i++)
		{
		ImageView image = (ImageView) findViewById(R.id.imageView2);
		TranslateAnimation anim = new TranslateAnimation(-1500, 1500, 50, 50);
		anim.setDuration(31000);
		anim.setFillAfter(true);
		image.startAnimation(anim);
		image.setImageResource(R.drawable.img2);
		}
		Intent fif = getIntent();
		 mProgressBar = (ProgressBar)findViewById(R.id.progressBar1);
		 mProgressBar2 = (ProgressBar)findViewById(R.id.progressBar2);
		 final Thread timerThread = new Thread() {
	          @Override
	          public void run() {
	              mbActive = true;
	              try {
	                  int waited = 0;
	                  while(mbActive && (waited < TIMER_RUNTIME)) {
	                      sleep(200);
	                      if(mbActive) {
	                          waited += 200;
	                          Progress(waited);
	                      }
	                  }
	          } catch(InterruptedException e) {
	              // do nothing
	          } finally {
	              onContinue();
	          }
	        }
	     };
	     timerThread.start();
	   }
	   public void Destroy() {
	       super.onDestroy();
	   }
	   public void Progress(final int timePassed) {
	       if(null != mProgressBar) {
	           // Ignore rounding error here
	           final int progress = mProgressBar.getMax() * timePassed / TIMER_RUNTIME;
	           mProgressBar.setProgress(progress);
	       }
	   }

	public void onContinue()
	{
		/*Intent result = new Intent(this,Result.class);
		startActivity(result);*/
		 final Thread timerThread2 = new Thread() {
	          public void run() {
	              mbActive2 = true;
	              try {
	                  int waited2 = 0;
	                  while(mbActive2 && (waited2 < TIMER2)) {
	                      sleep(200);
	                      if(mbActive2) {
	                          waited2 += 200;
	                          updateProgress(waited2);
	                      }
	                  }
	          } catch(InterruptedException e) {
	              // do nothing
	          } finally {
	              onContinue2();
	          }
	        }
	     };
	     timerThread2.start();
	   }
	   @Override
	   public void onDestroy() {
	       super.onDestroy();
	   }
	   public void updateProgress(final int timePassed) {
	       if(null != mProgressBar2) {
	           // Ignore rounding error here
	           final int progress2 = mProgressBar2.getMax() * timePassed / TIMER2;
	           mProgressBar2.setProgress(progress2);
	       }
	   }

	public void onContinue2()
	{
		Intent result = new Intent(this,Result.class);
		startActivity(result);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fifth, menu);
		return true;
	}

}

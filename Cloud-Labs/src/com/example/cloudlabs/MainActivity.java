package com.example.cloudlabs;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private GestureDetector gestureDetector;
@SuppressWarnings("deprecation")
@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
	
		TextView cld = (TextView) findViewById(R.id.textView1);  
		Typeface pic = Typeface.createFromAsset(getAssets(), "fonts/GREALN__.ttf");  
		cld.setTypeface(pic);  
		gestureDetector = new GestureDetector(new MyGestureDetector());
        View mainview = (View) findViewById(R.id.mainView);
        mainview.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (gestureDetector.onTouchEvent(event)) {
                    return true;
                }
                return false;
            }
        });
	}
class MyGestureDetector extends SimpleOnGestureListener {
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
    Intent intent = new Intent(MainActivity.this.getBaseContext(), Second.class);

       /* if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH) {
            return false ;
        }*/

        // right to left swipe
        if((e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE)||(e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE)||(e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE)||(e1.getY() - e2.getY() < SWIPE_MIN_DISTANCE) && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
		startActivity(intent);
		/*MainActivity.this.overridePendingTransition(
		R.anim.SLIDE_IN_RIGHT,
		R.anim.SLIDE_OUT_LEFT
		);
	    // right to left swipe
        }  else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
		startActivity(intent);
		MainActivity.this.overridePendingTransition(
		R.anim.slide_in_left, 
		R.anim.slide_out_right
		);*/
        }

        return false;
    }
    @Override
    public boolean onDown(MotionEvent e) {
        	return true;
    }
}
}

	

	    

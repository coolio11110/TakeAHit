//fix lag
package com.example.takeahit;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	static int count;
	AnimationDrawable anim;
	CountDownTimer timer;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		count = 0;
		final TextView timeLeft = (TextView) findViewById(R.id.timer);
		
		 timer = new CountDownTimer(150000, 1000) {

		     public void onTick(long millisUntilFinished) {
		         timeLeft.setText(String.valueOf(millisUntilFinished / 1000));
		     }

		     public void onFinish() {
		         timeLeft.setText("0");
		         Intent i = new Intent(MainActivity.this,EndActivity.class);
				startActivity(i);
				finish();
		     }
		  }.start();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void addHitCounter(View v) {
		final ImageView face = (ImageView) findViewById(R.id.angryface);
		
		if(v != face) {
			count++;
			TextView num = (TextView) findViewById(R.id.number);
			num.setText(String.valueOf(count));
			animationClick(v);
			donutDisappear(v);
		}
		else {
			timer.cancel();
			Intent i = new Intent(MainActivity.this,EndActivity.class);
			startActivity(i);
			finish();
		}
	}
	
	public void animationClick(View v) {
		ImageView img = (ImageView) findViewById(R.id.stonerGuy);
		anim = (AnimationDrawable) getResources().getDrawable(R.anim.animation);
		img.setImageDrawable(anim);
		anim.setVisible(false, true);
		anim.start();
	}
	
	public void donutDisappear(View v) {
		final ImageView do1 = (ImageView) findViewById(R.id.donut1);
		final ImageView do2 = (ImageView) findViewById(R.id.donut2);
		final ImageView do3 = (ImageView) findViewById(R.id.donut3);
		
		if(v == do1) {
			do1.setVisibility(4);
			
			v.postDelayed(new Runnable() {
				@Override
				public void run() {
					do1.setVisibility(0);
				}
			}, 5000);
		}
		if(v == do2) {
			do2.setVisibility(4);
			
			v.postDelayed(new Runnable() {
				@Override
				public void run() {
					do2.setVisibility(0);
				}
			}, 5000);
		}
		if(v == do3) {
			do3.setVisibility(4);
			
			v.postDelayed(new Runnable() {
				@Override
				public void run() {
					do3.setVisibility(0);
				}
			}, 5000);
		}
		
	}

}

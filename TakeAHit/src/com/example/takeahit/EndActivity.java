package com.example.takeahit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class EndActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_end);
		TextView text = (TextView) findViewById(R.id.scoreView);
		text.setText("Your score was: " + String.valueOf(MainActivity.count));
		
		SharedPreferences prefs = this.getSharedPreferences("myScore", Context.MODE_PRIVATE);
		int oldScore = prefs.getInt("score", 0);  
		if(MainActivity.count > oldScore ){
		   Editor edit = prefs.edit();
		   edit.putInt("score", MainActivity.count);
		   edit.commit();
		}
		TextView highText = (TextView) findViewById(R.id.highScoreView);
		highText.setText("Your high score was: " + String.valueOf(prefs.getInt("score", 0)));

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void replay(View v) {
		Intent i = new Intent(EndActivity.this,MainActivity.class);
		startActivity(i);
		finish();
	}
	
	public void goMain(View v) {
		Intent i = new Intent(EndActivity.this,MenuActivity.class);
		startActivity(i);
		finish();
	}
}

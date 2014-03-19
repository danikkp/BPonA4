package ru.danikkp.bpona4;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;


public class BPonA4Activity extends Activity
{

	private static final String TAG="BPonA4infoLog";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		log("Entered onCreate() method of MainActivity");		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);

		log("came here");

	}	

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		log("Entered onCreateOptionsMenu() of MainActivity");
		getMenuInflater().inflate(R.menu.bpon_a4, menu);
		return true;
	}

	void log(String logText)
	{
		Log.i(TAG, logText.toString());
	}
}

package ru.danikkp.bpona4;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;

public class BPonA4Activity extends Activity {

	private static final String TAG="BPonA4infoLog";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		log("Entered onCreate() method");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bpon_a4);
		
		//Register fragmentmanager to draw UI
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		
		// Check whether we are in normal or large layout
		if (isInTwoPaneMode()) {
			//fragmentTransaction.replace(R.id.planList, new PlanListFragment());
			fragmentTransaction.replace(R.id.planCanvas, new PlanCanvasFragment());
			fragmentTransaction.commit();
		} else {
			
		}
	}

	private boolean isInTwoPaneMode() {
		return findViewById(R.id.singleFragment)==null;		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bpon_a4, menu);
		return true;
	}
	
	void log(String logText) {
		Log.i(TAG, logText.toString());
	}

}

package ru.danikkp.bpona4;
import android.app.*;
import android.os.*;
import android.util.*;

public class PlanCanvasActivity extends Activity
{
	static final String TAG="BPonA4infoLog";
	
	void log(String logText) {
		Log.i(TAG, logText.toString());
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		log("Entered PlanCanvasActivity()");
		
		//if (getResources()
		
		if (savedInstanceState==null) {
			//todo: at setup, plug in canvas fragment
			
			//create and manage fragment manager
			PlanCanvasFragment planCanvasFrag = new PlanCanvasFragment();
			//get and set position input based on construction argument
			planCanvasFrag.setArguments(getIntent().getExtras());
			//
			getFragmentManager().beginTransaction().add(android.R.id.content,planCanvasFrag).commit();
			
		}
	}
	
}

package ru.danikkp.bpona4;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PlanCanvasFragment extends Fragment{
	
	private static final String TAG="BPonA4infoLog";

	public void log(String logText) {
		Log.i(TAG, logText.toString());
	}

	//create new instance of PlanCanvasFragment to show canvas of linked item with 'index'
	public static PlanCanvasFragment newInstance(int index) {
		
	//	log("Entered PlanCancasFragment() constructor");
		PlanCanvasFragment planCanvasFrag= new PlanCanvasFragment();
		
		//supply index input as an argument
		Bundle args = new Bundle();
		args.putInt("index",index);
		planCanvasFrag.setArguments(args);
		
		return planCanvasFrag;
	}
	
	public int getShownIndex() {
		log("Entered getShownIbdex()");
		return getArguments().getInt("index",0);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
				log(getClass().getSimpleName() + ":entered onCreateView() of PlanCanvasFragment");
		// TODO Auto-generated method stub		
		
		return inflater.inflate(R.layout.plan_canvas,container,false);
		//return inflater.inflate(R.layout.plan_canvas, container);
	}

	
	
}

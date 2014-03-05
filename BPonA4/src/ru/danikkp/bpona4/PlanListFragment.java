package ru.danikkp.bpona4;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class PlanListFragment extends ListFragment{

	final static String TAG="BPonA4infoLog";

	private String[] mPlanList;

		
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		log("Entered onCreateView() of PlanListFragment class");
		
		View planListView = inflater.inflate(R.layout.activity_bpon_a4, container, false);
		mPlanList = new String[]{"plan A","plan B","plan C"};
		ArrayAdapter<String> mPlanListAdapter = new ArrayAdapter<String>(getActivity(), R.layout.activity_bpon_a4,mPlanList);
		setListAdapter(mPlanListAdapter);

		return planListView;
	}


	void log(String logText) {
		Log.i(TAG, logText.toString());
	}

}

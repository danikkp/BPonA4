package ru.danikkp.bpona4;

import android.annotation.SuppressLint;
import android.app.*;
import android.content.*;
import android.os.*;
import android.util.*;
import android.widget.*;
import android.view.*;

@SuppressLint("InlinedApi")
public class PlanListFragment extends ListFragment
{

	final static String TAG="BPonA4infoLog";

	private boolean mDualPane;
	private int mCurCheckPosition=0;

	private String[] mPlanList = new String[]{"plan A","plan B","plan C"};

	//show plan canvas in fragment or in separate activity
	public void showPlanCanvas(int index)
	{
		log("Entered showPlanCanvas method of PlanListFragment");
		mCurCheckPosition = index;

		if (mDualPane)
		{
			getListView().setItemChecked(index, true);

			//check what fragment is shown now, relace if needed
			PlanCanvasFragment planCanvasFrag = (PlanCanvasFragment) getFragmentManager()
					.findFragmentById(R.id.planCanvas);
			if (planCanvasFrag == null || planCanvasFrag.getShownIndex() != index)
			{
				//make new fragment to show selected item
				planCanvasFrag = PlanCanvasFragment.newInstance(index);
				log("created or replaced fragment");
				//execute fragment transaction
				FragmentTransaction ft = getFragmentManager().beginTransaction();
				ft.replace(R.id.planCanvas, planCanvasFrag);
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.commit();
			}
		}
		else
		{
			//set and run plan canvas in separate activity
			Intent planCanvasIntent = new Intent(getActivity(), PlanCanvasActivity.class);
			planCanvasIntent.putExtra("index", index);
			startActivity(planCanvasIntent);
			log("came here 2");

		}
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		log("Entered onActivityCreated() of PlanListFragment");
		super.onActivityCreated(savedInstanceState);

		setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mPlanList));

		//check if we are in dual pane mode
		mDualPane = getActivity().findViewById(R.id.planCanvas) != null && 
				(getActivity().findViewById(R.id.planCanvas)).getVisibility() == View.VISIBLE;

		log("mDualPane " + mDualPane);

		if (savedInstanceState != null)
		{
			//restore last state for checked position
			mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
		}

		if (mDualPane)
		{
			getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
			showPlanCanvas(mCurCheckPosition);
		}
		else
		{
			getListView().setItemChecked(mCurCheckPosition, true);
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState)
	{
		// TODO: Implement this method
		log("Entered onSaveInstanceState() of PlanListFragment");
		super.onSaveInstanceState(outState);
		outState.putInt("curChoice", mCurCheckPosition);

	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id)
	{
		// TODO: Implement this method
		log("Entered onListItemClick() of PlanListFragment");
		super.onListItemClick(l, v, position, id);

		showPlanCanvas(position);
	}

	void log(String logText)
	{
		Log.i(TAG, logText.toString());
	}

}

package com.joopware.unitconverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author	Jeremy Kemp
 * @author	http://www.jeremykemp.co.uk/
 */
public class UnitConverter extends Activity 
{	
	private Intent myIntent;
	private ListView lv;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setRequestedOrientation(1);
		setContentView(R.layout.main_menu_list);
		
		//Creates a ListView that is populated via the main_menu array and displays it to the screen.  
		lv = (ListView)findViewById(R.id.ListViewId);
		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.main_menu)));

		lv.setOnItemClickListener(new OnItemClickListener()
		{
			/**
			 * Listens for a click on the main menu list. If one is found, switch is used based from
			 * the position of click in the list. The switch then changes to the appropriate screen.
			 */
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id)
			{
				switch (position)
				{
					case 0:	
						myIntent = new Intent(getApplicationContext(), AreaActivity.class); 
						startActivity(myIntent); 
						break;
					case 1:	
						myIntent = new Intent(getApplicationContext(), CurrencyActivity.class); 
						startActivity(myIntent); 
						break;
					case 2:	
						myIntent = new Intent(getApplicationContext(), LengthActivity.class); 
						startActivity(myIntent); 
						break;
					case 3:	
						myIntent = new Intent(getApplicationContext(), VolumeActivity.class); 
						startActivity(myIntent); 
						break;	
					case 4:
						myIntent = new Intent(getApplicationContext(), WeightActivity.class);
						startActivity(myIntent);
						break;
				}
			}
		});
	}
}
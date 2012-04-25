package com.joopware.unitconverter;

import android.os.Bundle;
/**
 * @author	Jeremy Kemp
 * @author	http://www.jeremykemp.co.uk/
 */
public class LengthActivity extends ConvertActivity
{	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setRequestedOrientation(1);
		setContentView(R.layout.convert_screen_layout);
		
		//Populates the source spinner with area unit types
		sourceSpinner = populate(sourceSpinner, R.id.SpinnerSelectSourceAreaUnit, R.array.length);		
		
		//Populates the desired spinner with area unit types
		desiredSpinner = populate(desiredSpinner, R.id.SpinnerSelectDesiredAreaUnit, R.array.length);
		
		/*Sets up the listened for button clicks on the convert button. Also informs what type of calculation to perform
		E.g. area, length etc*/
		buttonListen(ConvertType.length);
	}
}
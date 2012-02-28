package com.joopware.unitconverter;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author	Jeremy Kemp
 * @author	http://www.jeremykemp.co.uk/
 */
public class ConvertActivity extends Activity
{
	public Spinner sourceSpinner, desiredSpinner;
	private ArrayAdapter<CharSequence> adapter;
	private ConversionUtility converter;
	private TextView result, originalValue;
	private Button convertButton;
	private int conversionType;

	public ConvertActivity()
	{
		converter = new ConversionUtility();
	}

	/**
	 * Takes a spinner and populates it accordingly with the correct unit types.
	 * @param spinner The spinner to be populated.
	 * @param spinnerId The ID of the spinner to be populated.
	 * @param arrayId The ID of the array that will populate the spinner.
	 * @return Returns the populated spinner.
	 */
	public Spinner populate(Spinner spinner, int spinnerId, int arrayId)
	{
		spinner = (Spinner) findViewById(spinnerId);
		adapter = ArrayAdapter.createFromResource(this, arrayId, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		return spinner;
	}

	/**
	 * Provides the function to monitor button clicks on the convert button.
	 * When pressed, conversion is performed.
	 */
	public void buttonListen(int convertType)
	{
		conversionType = convertType;
		if(conversionType == 1)
		{
			ConnectivityManager connec = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
			if(connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED  && connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED)
			{
				Toast noInternetText = Toast.makeText(getApplicationContext(), "Currency conversion requires an active network connection", Toast.LENGTH_LONG);
				noInternetText.show();
				return;
			}
		}
		convertButton = (Button) findViewById(R.id.convertAreaButton);
		convertButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{

				result = (TextView) findViewById(R.id.resultLabel);
				originalValue = (TextView) findViewById(R.id.sourceArea);
				String originalValueString = originalValue.getText().toString();
				if(!originalValueString.equals(""))
				{
					NumberFormat formatter = new DecimalFormat("#,##0.######################################");
					String conversionResult = formatter.format(converter.convertValues(Double.parseDouble(originalValueString), sourceSpinner.getSelectedItem().toString(), desiredSpinner.getSelectedItem().toString(), conversionType)); 
					result.setText(conversionResult);
				}
				else
				{
					Toast emptyEditText = Toast.makeText(getApplicationContext(), R.string.invalid_number, Toast.LENGTH_LONG);
					emptyEditText.show();
				}
			}
		});
	}
}
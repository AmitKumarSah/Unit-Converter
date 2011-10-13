package com.joopware.unitconverter;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 * @author Jeremy Kemp
 * @author http://www.jeremykemp.co.uk/
 */
public class ConversionUtility 
{
	private HashMap<String, Double> areaConversionValues, lengthConversionValues, volumeConversionValues, 
	weightConversionValues;

	/**
	 * The constructor initialises each HashMap and fills it with all the
	 * correct conversion rates.
	 */
	public ConversionUtility() 
	{
		initialiseAreaValues();
		initialiseLengthValues();
		initialiseVolumeValues();
		initialiseWeightValues();
	}

	public void initialiseAreaValues() 
	{
		areaConversionValues = new HashMap<String, Double>();

		// millimetre to X
		areaConversionValues.put("MillimetreToMillimetre", 1.0);
		areaConversionValues.put("MillimetreToCentimetre", 0.01);
		areaConversionValues.put("MillimetreToMetre", 0.000002);
		areaConversionValues.put("MillimetreToKilometre", 0.000000000002);
		areaConversionValues.put("MillimetreToInch", 0.0015500031);
		areaConversionValues.put("MillimetreToFeet", 0.0000107639104);
		areaConversionValues.put("MillimetreToYard", 0.00000119599005);
		areaConversionValues.put("MillimetreToMile", 0.000000000000386102159);

		// Centimetre to X
		areaConversionValues.put("CentimetreToMillimetre", 100.0);
		areaConversionValues.put("CentimetreToCentimetre", 1.0);
		areaConversionValues.put("CentimetreToMetre", 0.0001);
		areaConversionValues.put("CentimetreToKilometre", 0.0000000001);
		areaConversionValues.put("CentimetreToInch", 0.15500031);
		areaConversionValues.put("CentimetreToFeet", 0.00107639104);
		areaConversionValues.put("CentimetreToYard", 0.000119599005);
		areaConversionValues.put("CentimetreToMile", 0.0000000000386102159);

		// metre to X
		areaConversionValues.put("MetreToMillimetre", 1000000.0);
		areaConversionValues.put("MetreToCentimetre", 10000.0);
		areaConversionValues.put("MetreToMetre", 1.0);
		areaConversionValues.put("MetreToKilometre", 0.0000010);
		areaConversionValues.put("MetreToInch", 1550.0031);
		areaConversionValues.put("MetreToFeet", 10.7639104);
		areaConversionValues.put("MetreToYard", 1.19599005);
		areaConversionValues.put("MetreToMile", 0.000000386102159);

		// Kilometre to X
		areaConversionValues.put("KilometreToMillimetre", 1000000000000.0);
		areaConversionValues.put("KilometreToCentimetre", 10000000000.0);
		areaConversionValues.put("KilometreToMetre", 1000000.0);
		areaConversionValues.put("KilometreToKilometre", 1.0);
		areaConversionValues.put("KilometreToInch", 1550003100.0);
		areaConversionValues.put("KilometreToFeet", 10763910.4);
		areaConversionValues.put("KilometreToYard", 1195990.05);
		areaConversionValues.put("KilometreToMile", 0.386102159);

		// Inch to X
		areaConversionValues.put("InchToMillimetre", 645.16);
		areaConversionValues.put("InchToCentimetre", 6.4516);
		areaConversionValues.put("InchToMetre", 0.00064516);
		areaConversionValues.put("InchToKilometre", 0.00000000064516);
		areaConversionValues.put("InchToInch", 1.0);
		areaConversionValues.put("InchToFeet", 0.00694444444);
		areaConversionValues.put("InchToYard", 0.000771604938);
		areaConversionValues.put("InchToMile", 0.000000000249097669);

		// Feet to X
		areaConversionValues.put("FeetToMillimetre", 304.8);
		areaConversionValues.put("FeetToCentimetre", 30.48);
		areaConversionValues.put("FeetToMetre", 0.3048);
		areaConversionValues.put("FeetToKilometre", 0.0003048);
		areaConversionValues.put("FeetToInch", 12.0);
		areaConversionValues.put("FeetToFeet", 1.0);
		areaConversionValues.put("FeetToYard", 0.111111111);
		areaConversionValues.put("FeetToMile", 0.0000000358700643);

		// Yard to X
		areaConversionValues.put("YardToMillimetre", 836127.36);
		areaConversionValues.put("YardToCentimetre", 8361.2736);
		areaConversionValues.put("YardToMetre", 0.83612736);
		areaConversionValues.put("YardToKilometre", 0.00000083612736);
		areaConversionValues.put("YardToInch", 1296.0);
		areaConversionValues.put("YardToFeet", 9.0);
		areaConversionValues.put("YardToYard", 1.0);
		areaConversionValues.put("YardToMile", 0.000000322830579);

		// Mile to X
		areaConversionValues.put("MileToMillimetre", 2589988110336.0);
		areaConversionValues.put("MileToCentimetre", 25899881100.0);
		areaConversionValues.put("MileToMetre", 2589988.1);
		areaConversionValues.put("MileToKilometre", 2.58998811);
		areaConversionValues.put("MileToInch", 4014489600.0);
		areaConversionValues.put("MileToFeet", 27878400.0);
		areaConversionValues.put("MileToYard", 3097600.0);
		areaConversionValues.put("MileToMile", 1.0);
	}

	public void initialiseLengthValues() 
	{
		lengthConversionValues = new HashMap<String, Double>();

		// millimetre to X
		lengthConversionValues.put("MillimetreToMillimetre", 1.0);
		lengthConversionValues.put("MillimetreToCentimetre", 0.1);
		lengthConversionValues.put("MillimetreToMetre", 0.01);
		lengthConversionValues.put("MillimetreToKilometre", 0.000001);
		lengthConversionValues.put("MillimetreToInch", 0.0393700787);
		lengthConversionValues.put("MillimetreToFeet", 0.0032808399);
		lengthConversionValues.put("MillimetreToYard", 0.0010936133);
		lengthConversionValues.put("MillimetreToMile", 0.000000621371192);

		// Centimetre to X
		lengthConversionValues.put("CentimetreToMillimetre", 10.0);
		lengthConversionValues.put("CentimetreToCentimetre", 1.0);
		lengthConversionValues.put("CentimetreToMetre", 0.01);
		lengthConversionValues.put("CentimetreToKilometre", 0.00001);
		lengthConversionValues.put("CentimetreToInch", 0.393700787);
		lengthConversionValues.put("CentimetreToFeet", 0.032808399);
		lengthConversionValues.put("CentimetreToYard", 0.010936133);
		lengthConversionValues.put("CentimetreToMile", 0.00000621371192);

		// metre to X
		lengthConversionValues.put("MetreToMillimetre", 1000.0);
		lengthConversionValues.put("MetreToCentimetre", 100.0);
		lengthConversionValues.put("MetreToMetre", 1.0);
		lengthConversionValues.put("MetreToKilometre", 0.001);
		lengthConversionValues.put("MetreToInch", 39.3700787);
		lengthConversionValues.put("MetreToFeet", 3.2808399);
		lengthConversionValues.put("MetreToYard", 1.0936133);
		lengthConversionValues.put("MetreToMile", 0.000621371192);

		// Kilometre to X
		lengthConversionValues.put("KilometreToMillimetre", 1000000.0);
		lengthConversionValues.put("KilometreToCentimetre", 100000.0);
		lengthConversionValues.put("KilometreToMetre", 1000.0);
		lengthConversionValues.put("KilometreToKilometre", 1.0);
		lengthConversionValues.put("KilometreToInch", 39370.0787);
		lengthConversionValues.put("KilometreToFeet", 3280.8399);
		lengthConversionValues.put("KilometreToYard", 1093.6133);
		lengthConversionValues.put("KilometreToMile", 0.621371192);

		// Inch to X
		lengthConversionValues.put("InchToMillimetre", 25.4);
		lengthConversionValues.put("InchToCentimetre", 2.54);
		lengthConversionValues.put("InchToMetre", 0.0254);
		lengthConversionValues.put("InchToKilometre", 0.0000254);
		lengthConversionValues.put("InchToInch", 1.0);
		lengthConversionValues.put("InchToFeet", 0.0833333);
		lengthConversionValues.put("InchToYard", 0.0277777778);
		lengthConversionValues.put("InchToMile", 0.0000157828283);

		// Feet to X
		lengthConversionValues.put("FeetToMillimetre", 304.8);
		lengthConversionValues.put("FeetToCentimetre", 30.48);
		lengthConversionValues.put("FeetToMetre", 0.3048);
		lengthConversionValues.put("FeetToKilometre", 0.0003048);
		lengthConversionValues.put("FeetToInch", 12.0);
		lengthConversionValues.put("FeetToFeet", 1.0);
		lengthConversionValues.put("FeetToYard", 0.333333333);
		lengthConversionValues.put("FeetToMile", 0.000189393939);

		// Yard to X
		lengthConversionValues.put("YardToMillimetre", 914.4);
		lengthConversionValues.put("YardToCentimetre", 91.44);
		lengthConversionValues.put("YardToMetre", 0.9144);
		lengthConversionValues.put("YardToKilometre", 0.0009144);
		lengthConversionValues.put("YardToInch", 36.0);
		lengthConversionValues.put("YardToFeet", 3.0);
		lengthConversionValues.put("YardToYard", 1.0);
		lengthConversionValues.put("YardToMile", 0.000568181818);

		// Mile to X
		lengthConversionValues.put("MileToMillimetre", 1609344.0);
		lengthConversionValues.put("MileToCentimetre", 160934.4);
		lengthConversionValues.put("MileToMetre", 1609.344);
		lengthConversionValues.put("MileToKilometre", 1.609344);
		lengthConversionValues.put("MileToInch", 63360.0);
		lengthConversionValues.put("MileToFeet", 5280.0);
		lengthConversionValues.put("MileToYard", 1760.0);
		lengthConversionValues.put("MileToMile", 1.0);
	}

	public void initialiseVolumeValues() 
	{
		volumeConversionValues = new HashMap<String, Double>();

		// millimetre to X
		volumeConversionValues.put("MillimetreToMillimetre", 1.0);
		volumeConversionValues.put("MillimetreToCentimetre", 0.001);
		volumeConversionValues.put("MillimetreToMetre", 0.0000000010);
		volumeConversionValues.put("MillimetreToKilometre",	0.0000000000000000010);
		volumeConversionValues.put("MillimetreToInch", 0.0000610237441);
		volumeConversionValues.put("MillimetreToFeet", 0.0000000353146667);
		volumeConversionValues.put("MillimetreToYard", 0.00000000130795062);
		volumeConversionValues.put("MillimetreToMile", 0.000000000000000000239912759);

		// Centimetre to X
		volumeConversionValues.put("CentimetreToMillimetre", 1000.0);
		volumeConversionValues.put("CentimetreToCentimetre", 1.0);
		volumeConversionValues.put("CentimetreToMetre", 0.0000010);
		volumeConversionValues.put("CentimetreToKilometre", 0.0000000000000010);
		volumeConversionValues.put("CentimetreToInch", 0.0610237441);
		volumeConversionValues.put("CentimetreToFeet", 0.0000353146667);
		volumeConversionValues.put("CentimetreToYard", 0.00000130795062);
		volumeConversionValues.put("CentimetreToMile", 0.000000000000000239912759);

		// metre to X
		volumeConversionValues.put("MetreToMillimetre", 1000000000.0);
		volumeConversionValues.put("MetreToCentimetre", 1000000.0);
		volumeConversionValues.put("MetreToMetre", 1.0);
		volumeConversionValues.put("MetreToKilometre", 0.0000000010);
		volumeConversionValues.put("MetreToInch", 61023.7441);
		volumeConversionValues.put("MetreToFeet", 35.3146667);
		volumeConversionValues.put("MetreToYard", 1.30795062);
		volumeConversionValues.put("MetreToMile", 0.000000000239912759);

		// Kilometre to X
		volumeConversionValues.put("KilometreToMillimetre",	1000000000000000000.0);
		volumeConversionValues.put("KilometreToCentimetre", 1000000000000000.0);
		volumeConversionValues.put("KilometreToMetre", 1000000000.0);
		volumeConversionValues.put("KilometreToKilometre", 1.0);
		volumeConversionValues.put("KilometreToInch", 61023744100000.0);
		volumeConversionValues.put("KilometreToFeet", 35314666700.0);
		volumeConversionValues.put("KilometreToYard", 1307950620.0);
		volumeConversionValues.put("KilometreToMile", 0.239912759);

		// Inch to X
		volumeConversionValues.put("InchToMillimetre", 16387.064);
		volumeConversionValues.put("InchToCentimetre", 16.387064);
		volumeConversionValues.put("InchToMetre", 0.000016387064);
		volumeConversionValues.put("InchToKilometre", 0.000000000000016387064);
		volumeConversionValues.put("InchToInch", 1.0);
		volumeConversionValues.put("InchToFeet", 0.000578703704);
		volumeConversionValues.put("InchToYard", 0.0000214334705);
		volumeConversionValues.put("InchToMile", 0.00000000000000393146573);

		// Feet to X
		volumeConversionValues.put("FeetToMillimetre", 28316846.6);
		volumeConversionValues.put("FeetToCentimetre", 28316.8466);
		volumeConversionValues.put("FeetToMetre", 0.0283168466);
		volumeConversionValues.put("FeetToKilometre", 0.0000000000283168466);
		volumeConversionValues.put("FeetToInch", 1728.0);
		volumeConversionValues.put("FeetToFeet", 1.0);
		volumeConversionValues.put("FeetToYard", 0.037037037);
		volumeConversionValues.put("FeetToMile", 0.00000000000679357278);

		// Yard to X
		volumeConversionValues.put("YardToMillimetre", 764554858.0);
		volumeConversionValues.put("YardToCentimetre", 764554.858);
		volumeConversionValues.put("YardToMetre", 0.764554858);
		volumeConversionValues.put("YardToKilometre", 0.000000000764554858);
		volumeConversionValues.put("YardToInch", 46656.0);
		volumeConversionValues.put("YardToFeet", 27.0);
		volumeConversionValues.put("YardToYard", 1.0);
		volumeConversionValues.put("YardToMile", 0.000000000183426465);

		// Mile to X
		volumeConversionValues.put("MileToMillimetre", 4168181830000000000.0);
		volumeConversionValues.put("MileToCentimetre", 4168181830000000.0);
		volumeConversionValues.put("MileToMetre", 4168181830.0);
		volumeConversionValues.put("MileToKilometre", 4.16818183);
		volumeConversionValues.put("MileToInch", 254358061000000.0);
		volumeConversionValues.put("MileToFeet", 147197952000.0);
		volumeConversionValues.put("MileToYard", 5451776000.0);
		volumeConversionValues.put("MileToMile", 1.0);
	}

	private void initialiseWeightValues()
	{
		weightConversionValues = new HashMap<String, Double>();

		// Milligram to X
		weightConversionValues.put("MilligramToMilligram", 1.0);
		weightConversionValues.put("MilligramToGram", 0.001);
		weightConversionValues.put("MilligramToKilogram", 0.0000010);
		weightConversionValues.put("MilligramToOunce", 0.0000352739619);
		weightConversionValues.put("MilligramToPound", 0.00000220462262);
		weightConversionValues.put("MilligramToStone", 0.000000157473044);
		weightConversionValues.put("MilligramToMetric Ton", 0.0000000010);
		weightConversionValues.put("MilligramToTon", 0.00000000110231131);

		// Gram to X
		weightConversionValues.put("GramToMilligram", 1000.0);
		weightConversionValues.put("GramToGram", 1.0);
		weightConversionValues.put("GramToKilogram", 0.001);
		weightConversionValues.put("GramToOunce", 0.0352739619);
		weightConversionValues.put("GramToPound", 0.00220462262);
		weightConversionValues.put("GramToStone", 0.000157473044);
		weightConversionValues.put("GramToMetric Ton", 0.0000010);
		weightConversionValues.put("GramToTon", 0.00000110231131);

		// Kilogram to X
		weightConversionValues.put("KilogramToGram", 1000.0);
		weightConversionValues.put("KilogramToMilligram", 1000000.0);
		weightConversionValues.put("KilogramToKilogram", 1.0);
		weightConversionValues.put("KilogramToOunce", 35.2739619);
		weightConversionValues.put("KilogramToPound", 2.20462262);
		weightConversionValues.put("KilogramToStone", 0.157473044);
		weightConversionValues.put("KilogramToMetric Ton", 0.001);
		weightConversionValues.put("KilogramToTon", 0.00110231131);

		// Ounce to X
		weightConversionValues.put("OunceToGram", 28.3495231);
		weightConversionValues.put("OunceToMilligram", 28349.5231);
		weightConversionValues.put("OunceToKilogram", 0.0283495231);
		weightConversionValues.put("OunceToOunce", 1.0);
		weightConversionValues.put("OunceToPound", 0.0625);
		weightConversionValues.put("OunceToStone", 0.00446428571);
		weightConversionValues.put("OunceToMetric Ton", 0.0000283495231);
		weightConversionValues.put("OunceToTon", 0.0000312500);

		// Pound to X
		weightConversionValues.put("PoundToGram", 453.59237);
		weightConversionValues.put("PoundToMilligram", 453592.37);
		weightConversionValues.put("PoundToKilogram", 0.45359237);
		weightConversionValues.put("PoundToOunce", 16.0);
		weightConversionValues.put("PoundToPound", 1.0);
		weightConversionValues.put("PoundToStone", 0.0714285714);
		weightConversionValues.put("PoundToMetric Ton", 0.00045359237);
		weightConversionValues.put("PoundToTon", 0.0005);
	}

	public double calculateCurrency(double input, String from, String to) 
	{
		Currency currency;
		String sourceCurrency = from.substring(0, 3);
		String desiredCurrency = to.substring(0, 3);
		String description, subString;
		double conversionRate = 1;

		try {
			// Create URL to XML file
			URL url = new URL("http://themoneyconverter.com/" + sourceCurrency + "/rss.xml");

			// Get a SAXParser from the SAXParserFactory
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();

			// Get the XMLReader of the SAXParser
			XMLReader xr = sp.getXMLReader();

			// Create a new ContentHandler and apply it back to the XMLReader
			SaxParser mySaxParser = new SaxParser();
			xr.setContentHandler(mySaxParser);

			// Parse the XML Data from the URL
			xr.parse(new InputSource(url.openStream()));

			Iterator<Currency> currencyIterator = mySaxParser.currencyList.iterator();			
			while (currencyIterator.hasNext()) 
			{

				currency = currencyIterator.next();

				if (currency.getTitle().substring(0, 3).equals(desiredCurrency)) 
				{
					description = currency.getDescription();					
					subString = description.substring(description.indexOf("=") + 2, description.indexOf("=") + 9);
					conversionRate = Double.parseDouble(subString);
					break;
				}
			}

		} 
		catch (Exception e) 
		{
			System.out.println("There was an error in creating the XML parsing");
		}
		return input * conversionRate;
	}

	/**
	 * This method will return a {@link double} with the conversion result by
	 * looking up the conversion rate from {@link #lengthConversionValues} and
	 * multiplying against {@link input}.
	 * 
	 * @param input
	 * The input value.
	 * @param from
	 * Source unit type.
	 * @param to
	 * Desired unit type.
	 * @param conversionType
	 * The desired conversion type. E.g. Area, Volume etc.
	 * @return The result of the conversion.
	 */
	public double convertValues(double input, String from, String to, int conversionType) 
	{
		double result = 0.0;
		switch (conversionType) 
		{
		case 0:
			result = input * areaConversionValues.get(from + "To" + to);
			break; // 0 = Area
		case 1:
			result = calculateCurrency(input, from, to);
			DecimalFormat df = new DecimalFormat("#.##");
			result = Double.parseDouble(df.format(result));
			break; // 1 = Currency
		case 2:
			result = input * lengthConversionValues.get(from + "To" + to);
			break; // 2 = Length
		case 3:
			result = input * volumeConversionValues.get(from + "To" + to);
			break; // 3 = Volume
		case 4:
			result = input * weightConversionValues.get(from + "To" + to);
			break; // 4 = Weight
		}
		return result;
	}
}
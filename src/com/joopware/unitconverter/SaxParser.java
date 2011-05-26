package com.joopware.unitconverter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser extends DefaultHandler
{

	public List<Currency> currencyList;
	private String tempVal;

	//to maintain context
	private Currency currency;


	public SaxParser()
	{
		currencyList = new ArrayList<Currency>();
	}
	
	public List<Currency> getCurrencyList()
	{
		return currencyList;
	}
	
	/**
	 * Iterate through the list and print
	 * the contents
	 */
	public void printData()
	{		
		Iterator<Currency> currencyIterator = currencyList.iterator();
		while(currencyIterator.hasNext()) 
		{
			System.out.println(currencyIterator.next().toString());
		}
	}

	//Event Handlers
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException 
	{
		//reset
		tempVal = "";
		if(qName.equalsIgnoreCase("Title")) 
		{
			//create a new instance of employee
			currency = new Currency();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException 
	{
		tempVal = new String(ch,start,length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException 
	{

		if(qName.equalsIgnoreCase("Item")){
			//add it to the list
			currencyList.add(currency);
		}
		else if (qName.equalsIgnoreCase("Title")) {
			currency.setTitle(tempVal);
		}else if (qName.equalsIgnoreCase("Link")) {
			currency.setLink(tempVal);
		}else if (qName.equalsIgnoreCase("Guid")) {
			currency.setGuid(tempVal);
		}else if (qName.equalsIgnoreCase("PubDate")) {
			currency.setPubDate(tempVal);
		}else if (qName.equalsIgnoreCase("Description")) {
			currency.setDescription(tempVal);
		}else if (qName.equalsIgnoreCase("Category")) {
			currency.setCategory(tempVal);
		}
	}
}
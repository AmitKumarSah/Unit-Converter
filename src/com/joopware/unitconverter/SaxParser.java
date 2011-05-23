package com.joopware.unitconverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser extends DefaultHandler{

	List<Currency> currencyList;

	private String tempVal;

	//to maintain context
	private Currency currency;


	public SaxParser(String source){
		currencyList = new ArrayList<Currency>();
	}

	public void runExample() {
		parseDocument();
		printData();
	}

	private void parseDocument() {
		//get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {

			//get a new instance of parser
			SAXParser sp = spf.newSAXParser();

			//parse the file and also register this class for call backs
			sp.parse("http://themoneyconverter.com/GBP/rss.xml", this);

		}catch(SAXException se) {
			se.printStackTrace();
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	/**
	 * Iterate through the list and print
	 * the contents
	 */
	private void printData(){		
		Iterator<Currency> currencyIterator = currencyList.iterator();
		while(currencyIterator.hasNext()) {
			System.out.println(currencyIterator.next().toString());
		}
	}


	//Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//reset
		tempVal = "";
		if(qName.equalsIgnoreCase("Title")) {
			//create a new instance of employee
			currency = new Currency();
		}
	}


	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch,start,length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {

		if(qName.equalsIgnoreCase("Item")) {
			//add it to the list
			currencyList.add(currency);

		}else if (qName.equalsIgnoreCase("Title")) {
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
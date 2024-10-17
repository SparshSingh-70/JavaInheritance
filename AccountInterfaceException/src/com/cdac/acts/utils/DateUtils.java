package com.cdac.acts.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static final String FORMAT = "dd/MM/yyyy";
	private static final String EMPTY = "";
	
	private DateUtils() {
		// do nothing constructor to stop from object instantiation
	}
	
	// convert the string from user to date object and pass to the method below
	//Using parse of sdf
	
	public static Date getDate(String strdate) throws ParseException {
		if(strdate == null || EMPTY.equals(strdate)) {
			return null;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
		Date date = sdf.parse(strdate);
		
		return date;
		
		
	}
	
	
	//Converting Date object to formatted date of type string 
	//using .format of sdf
	public static String getFormattedDate(Date date) {
		if(date == null ) {
			return null;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
		return sdf.format(date);
	}
	
	
	
}

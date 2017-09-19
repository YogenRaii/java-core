/**
 * 
 */
package com.eprogrammerz.examples.general.dateapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

/**
 * @author Yogen
 *
 */
public class DateExample {
	public static void main(String[] args) {
		final String DEGREE  = "\u00b0";
	    System.out.println(DEGREE);
		
		
		DateTime todayNoon = new DateTime().withTimeAtStartOfDay().plusHours(12); 
		long todayNoonMills = todayNoon.getMillis();
		System.out.println(todayNoonMills);
		System.out.println(1500940800);
		Date date = new Date(todayNoonMills);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
	}

}

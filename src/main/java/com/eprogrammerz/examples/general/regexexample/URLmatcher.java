/**
 * 
 */
package com.eprogrammerz.examples.general.regexexample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Yogen
 *
 */
public class URLmatcher {

	public static void main(String[] args) {
		String url = "/api/v0.1/userrs?name=yogen&password=pass";
		final String URL_PATTERN = "/api/([a-z0-9.]+)/(?!users)([a-zA-Z0-9]+)(/([a-z0-9]+))*(\\?([a-zA-Z0-9]+)=([a-z0-9]+)(&([a-zA-Z0-9]+)=([a-z0-9]+))*)*";
		Pattern r = Pattern.compile(URL_PATTERN);
		Matcher m = r.matcher(url);
		
		if(m.find()) {
			System.out.println("Found : " + m.group(0));
		} else {
			System.out.println("Not Found.");
		}
	}
}

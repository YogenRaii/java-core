package com.eprogrammerz.examples.general.regexexample;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class IpAddressMatcher {
    private static String pattern= "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    private final Pattern regexPattern = Pattern.compile(pattern);
    
    public boolean isValidIp(final String ip) {
        Matcher matcher = regexPattern.matcher(ip);
        return matcher.matches();
    }

    @Test
    public void testIsValidIp() {
        assertTrue(isValidIp("000.12.12.034"));
        assertTrue(isValidIp("121.234.12.21"));
        assertTrue(isValidIp("23.45.12.65"));
        assertTrue(isValidIp("0.1.2.3"));
        assertFalse(isValidIp("666.666.23.23"));
        assertFalse(isValidIp(".12.32.232.23"));
    }
}
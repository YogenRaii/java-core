package com.eprogrammerz.examples.general.regexexample.ip_regex;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegex extends Solution {
    private static String pattern= "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    private final Pattern regexPattern;
    private final String ip;

    public MyRegex(String ip) {
        this.regexPattern = Pattern.compile(pattern);
        this.ip = ip;
    }

    public boolean isMatch() {
        Matcher matcher = regexPattern.matcher(this.ip);
        return matcher.matches();
    }
}

class Solution {
    public static void main(String[] args) {
        List<String> ips = Arrays.asList("000.12.12.034","121.234.12.21","23.45.12.65","0.1.2.3","666.666.23.23",".12.32.232.23");
        for(String ip: ips) {
            MyRegex mr = new MyRegex(ip);
            System.out.println(mr.isMatch());
        }

        /*Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String ip = in.next();
            MyRegex mr = new MyRegex(ip);
            System.out.println(mr.isMatch());
        }
        in.close();*/
    }
}
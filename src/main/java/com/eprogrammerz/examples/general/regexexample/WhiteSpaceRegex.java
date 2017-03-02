package com.eprogrammerz.examples.general.regexexample;

/**
 * Created by 542596 on 3/2/2017.
 */
public class WhiteSpaceRegex {
    public static void main(String[] args) {
        String str = " a";
        System.out.println(str.matches(" +"));
    }
}

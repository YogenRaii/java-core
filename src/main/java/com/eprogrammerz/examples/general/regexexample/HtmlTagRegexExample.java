package com.eprogrammerz.examples.general.regexexample;

/**
 * Created by 542596 on 3/9/2017.
 */
public class HtmlTagRegexExample {
    public static void main(String[] args) {
        String htmlString = "<prs>contents</pr>";
        String tagRemovedString = htmlString.replaceAll("<[A-Za-z]+>|</[A-Za-z]+>","");
        System.out.println(tagRemovedString);

        //you can not compare with null in either parameter
        System.out.println("yogen".compareToIgnoreCase(null));
    }
}

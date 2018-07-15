package com.eprogrammerz.examples.general.regexexample;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yogen on 3/9/2017.
 */
public class HtmlTagRemover {
    public String removeHtmlTags(String htmlString) {
        return htmlString.replaceAll("<[A-Za-z1-9]+>|</[A-Za-z1-9]+>","");
    }

    @Test
    public void testRemoveHtmlTags() {
        assertEquals("contents",removeHtmlTags("<h1>contents</h1>"));
        assertEquals("contents",removeHtmlTags("<html>contents</html>"));
        assertEquals("contents",removeHtmlTags("<prs>contents</pr>"));
    }
}

package com.eprogrammerz.examples.ds.browser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BrowserTest {

    @Test
    public void testBrowser() {
        Browser browser = new Browser();
        browser.newPage("yogen.rai");
        assertEquals("yogen.rai", browser.getCurrentAddress());

        browser.back();
        assertEquals("", browser.getCurrentAddress());

        browser.forward();
        assertEquals("yogen.rai", browser.getCurrentAddress());


        browser.newPage("new.yogen.rai");
        assertEquals("new.yogen.rai", browser.getCurrentAddress());

        browser.back();
        assertEquals("yogen.rai", browser.getCurrentAddress());

        browser.forward();
        assertEquals("new.yogen.rai", browser.getCurrentAddress());

        browser.back();
        assertEquals("yogen.rai", browser.getCurrentAddress());

        browser.newPage("very.new.yogen.rai");
        assertEquals("very.new.yogen.rai", browser.getCurrentAddress());

        assertNull(browser.forward());

        assertEquals("yogen.rai", browser.back());

        assertEquals("click.yogen.rai", browser.click("click.yogen.rai"));
        assertEquals("click.yogen.rai", browser.getCurrentAddress());

        assertEquals("yogen.rai", browser.back());
        assertEquals("click.yogen.rai", browser.forward());
    }
}

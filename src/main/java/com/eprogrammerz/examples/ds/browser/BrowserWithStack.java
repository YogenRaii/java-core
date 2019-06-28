package com.eprogrammerz.examples.ds.browser;

import java.util.Stack;

/**
 * Design a browser
 * 1. Enter address on address bar
 * 2. Click on link to go to new page
 * 2. User should be able to click on back button to get to the earlier back page
 * 3. User should be able to click on forward to get the earlier forward page
 * 3. If user enters new address on address bar, loses forward pages but retains backward pages
 */

public class BrowserWithStack {
    private Stack<String> back;
    private Stack<String> forward;

    private String current;

    public BrowserWithStack() {
        this.current = "";
        this.back = new Stack<>();
        this.forward = new Stack<>();
    }

    void newPage(String address) {
        this.back.push(this.current);
        this.current = address;

        /**
         * all forward history has to be cleaned if present
         */
        if (!forward.isEmpty()) {  // O(n)
            while (!forward.isEmpty()) {
                forward.pop();
            }
        }
    }

    String back() {
        if (back.isEmpty()) return null;

        forward.push(this.current);

        current = back.pop();

        return current;
    }

    String forward() {
        if (forward.isEmpty()) return null;

        /**
         * if current state is not the default page, then
         * we should push that to back stack
         */
        back.push(this.current);

        current = forward.pop();

        return current;
    }

    String click(String newAddress) {
        this.back.push(current);
        current = newAddress;

        /**
         * If there is forward history, they have to be cleaned
         */
        if (!forward.isEmpty()) {
            while (!forward.isEmpty()) {
                forward.pop();
            }
        }
        return current;
    }

    public String getCurrentAddress() {
        return current;
    }
}

package com.eprogrammerz.examples.ds.browser;

/**
 * Design a browser
 * 1. Enter address on address bar
 * 2. Click on link to go to new page
 * 2. User should be able to click on back button to get to the earlier back page
 * 3. User should be able to click on forward to get the earlier forward page
 * 3. If user enters new address on address bar, loses forward pages but retains backward pages
 */
public class Browser {
    private class BrowserState {
        String address;
        BrowserState back;
        BrowserState forward;

        BrowserState(String address) {
            this.address = address;
        }
    }

    private BrowserState browserState;

    /**
     * Browser starts with no particular address
     */
    public Browser() {
        this.browserState = new BrowserState("");
    }

    /**
     * When new address is entered in url input, then it adds new node into list
     * @param address
     */
    void newPage(String address) {
        BrowserState current = browserState;
        if (current.forward != null) {
            current.forward.back = null;
        }

        BrowserState newState = new BrowserState(address);
        newState.forward = null;
        newState.back = current;

        current.forward = newState;

        browserState = newState;
    }

    /**
     * If link within current page is linked, history will be updated
     * @param newAddress
     * @return
     */
    String click(String newAddress) {
        BrowserState newState = new BrowserState(newAddress);
        newState.forward = null;
        newState.back = browserState;

        browserState.forward = newState;
        browserState = newState;
        return browserState.address;
    }

    /**
     * Clicking on back doesn't takes to the previous page in the history if exists
     *
     * @return
     */
    String back() {
        BrowserState currentState = browserState;
        if (currentState.back != null) {
            currentState = currentState.back;
            browserState = currentState;
        }
        return browserState.address;
    }

    /**
     * Clicking on forward takes to the forward page in history if exists
     * @return
     */
    String forward() {
        if (browserState.forward != null) {
            browserState = browserState.forward;
            return browserState.address;
        }
        return null;
    }

    /**
     * Gives current address
     * @return
     */
    String getCurrentAddress() {
        return this.browserState.address;
    }
}

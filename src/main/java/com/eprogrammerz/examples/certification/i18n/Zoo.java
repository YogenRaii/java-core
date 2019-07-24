package com.eprogrammerz.examples.certification.i18n;

import java.util.ListResourceBundle;

public class Zoo extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][] {
            {"default", "Default"}
        };
    }
}

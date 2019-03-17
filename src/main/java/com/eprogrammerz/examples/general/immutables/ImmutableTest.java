package com.eprogrammerz.examples.general.immutables;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImmutableTest {
    @Test
    public void testImmutableObjs() {
        String firstName = "yogen";
        String lastName = "rai";

        // concatenate two strings
        String fullName = firstName.concat(" ").concat(lastName);

        assertEquals("yogen", firstName);
        assertEquals("rai", lastName);
        assertEquals("yogen rai", fullName);
    }
}

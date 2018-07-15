package com.eprogrammerz.examples.general.enums;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnumTest {

    @Test
    public void testFileType() {
        // return value for enum
        assertEquals("1x1", FileType.ONE_BY_ONE.getValue());

        // return enum for value
        assertEquals(FileType.ONE_BY_ONE, FileType.forValue("1x1"));
        assertEquals(FileType.ONE_BY_ONE, FileType.forValue("1X1"));
    }
}

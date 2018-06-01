package com.eprogrammerz.examples.java8.features;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.*;

/**
 * Created by 542596 on 11/9/2016.
 *
 * Stream lets developer to process data declaratively and leverage multicore architecture without the need to write
 * any specific code for it.
 */
public class StreamExample {
    public List<String> filterEmptyStrings(final List<String> originalList) {
        return originalList.stream().filter(str -> !str.trim().isEmpty()).collect(Collectors.toList());
    }

    public String concateNonEmptyString(final List<String> originalList, String delimiter) {
        final List<String> filterd = filterEmptyStrings(originalList);
        return filterd.stream().collect(Collectors.joining(delimiter));
    }

    @Test
    public void filterEmptyStringsReturnsOnlyNonEmptyStrings() {
        List<String> strings = Arrays.asList("abc"," ","bc","delta"," ","yogen");
        List<String> filtered = filterEmptyStrings(strings);
        filtered.forEach(str -> assertFalse(str.isEmpty()));
        assertTrue(filtered.size() == 4);
    }

    @Test
    public void concateNonEmptyStringReturnsStringConcatenatedWithGivenDelimiter() {
        List<String> strings = Arrays.asList("abc"," ","bc","delta"," ","yogen");
        assertEquals("abc,bc,delta,yogen", concateNonEmptyString(strings, ","));
        assertEquals("abc:bc:delta:yogen", concateNonEmptyString(strings, ":"));
    }
}

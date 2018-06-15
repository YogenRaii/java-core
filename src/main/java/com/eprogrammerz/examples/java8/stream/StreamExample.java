package com.eprogrammerz.examples.java8.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static junit.framework.TestCase.*;

/**
 * Created by Yogen on 11/9/2016.
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

    public String concateNonEmptyStringV2(final List<String> originalList, String delimiter) {
        final List<String> filterd = filterEmptyStrings(originalList);
        return String.join(delimiter, filterd);
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

        assertEquals("abc,bc,delta,yogen", concateNonEmptyStringV2(strings, ","));
        assertEquals("abc:bc:delta:yogen", concateNonEmptyStringV2(strings, ":"));
    }

    public Map<String, String> sortMapByValue(final Map<String, String> map) {
        return map.entrySet().stream().sorted((s1, s2) -> s2.getValue().length() - s1.getValue().length())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    @Test
    public void testSortMapByValue() {
        Map<String, String> strings = new HashMap<>();
        strings.put("1", "first");
        strings.put("2", "second");
        strings.put("3", "third");
        strings.put("4", "four");

        Map<String, String> expected = new LinkedHashMap<>();
        expected.put("2", "second");
        expected.put("1", "first");
        expected.put("3", "third");
        expected.put("4", "four");

        assertEquals(expected, sortMapByValue(strings));
    }
}

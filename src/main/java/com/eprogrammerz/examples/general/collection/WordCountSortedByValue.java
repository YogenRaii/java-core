/**
 *
 */
package com.eprogrammerz.examples.general.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen
 */
public class WordCountSortedByValue {

    @Test
    public void testSortByValue() {
        String[] elems = {"a", "b", "c", "b", "d", "a", "b"};

        Map<String, Long> wordCounts  = countWords(elems);

        Map<String, Long> expected = new LinkedHashMap<>();
        expected.put("b", 3L);
        expected.put("a", 2L);
        expected.put("c", 1L);
        expected.put("d", 1L);

        assertEquals(expected, wordCounts);
    }

    public Map<String, Long> countWords(final String[] words) {

        final Map<String, Long> wordCounts = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return wordCounts.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
//                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}

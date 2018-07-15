/**
 *
 */
package com.eprogrammerz.examples.general.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen
 */
public class SortMapByValue {

    @Test
    public void testSortByValue() {
        String[] elems = {"a", "b", "c", "b", "d", "a", "b"};

        Map<String, Integer> wordCounts  = countWords(elems);

        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("b", 3);
        expected.put("a", 2);
        expected.put("c", 1);
        expected.put("d", 1);

        assertEquals(expected, wordCounts);
    }

    public Map<String, Integer> countWords(final String[] words) {
        final Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        final Map<String, Integer> sortedByCount = wordCounts.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return sortedByCount;
    }
}

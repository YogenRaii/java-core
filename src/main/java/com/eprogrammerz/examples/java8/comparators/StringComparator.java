package com.eprogrammerz.examples.java8.comparators;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 */
public class StringComparator {
    public void sortNewWay(final List<String> words) {
        words.sort(Comparator.comparing(String::length).reversed().thenComparing(Comparator.naturalOrder()));

//        words.sort(Comparator.comparing(String::length)
//                .thenComparing(Comparator.reverseOrder()).reversed());
    }

    public void sortNewWayIntuitive(final List<String> words) {
        final Function<String, Integer> byLength = s -> s.length();
        words.sort(Comparator.comparing(byLength)
                .thenComparing(Comparator.reverseOrder()).reversed());
    }

    public void sortOldWay(final List<String> words) {
        words.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s2.length() == s1.length()) {
                    return s1.compareTo(s2);
                } else {
                    return s2.length() - s1.length();
                }
            }
        });
    }

    @Test
    public void testSortOldWay() {
        final List<String> names = Arrays.asList("Yogen", "Dipen", "Rita", "Dipa", "Prateema");
        final List<String> sorted = Arrays.asList("Prateema", "Dipen", "Yogen", "Dipa", "Rita");
        // execute
        sortOldWay(names);
        // verify
        assertEquals(sorted, names);
    }

    @Test
    public void testSortNewWay() {
        final List<String> names = Arrays.asList("Yogen", "Dipen", "Rita", "Dipa", "Prateema");
        final List<String> sorted = Arrays.asList("Prateema", "Dipen", "Yogen", "Dipa", "Rita");
        // execute
        sortNewWay(names);
        // verify
        assertEquals(sorted, names);
    }
}

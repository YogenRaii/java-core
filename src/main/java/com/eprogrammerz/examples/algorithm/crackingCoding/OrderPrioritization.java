package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class OrderPrioritization {
    public List<String> prioritize(List<String> orders) {
        List<String> nonPrimes = orders.stream().filter(o -> isNum(o.split(" ")[1])).collect(Collectors.toList());

        List<String> primes = orders.stream().filter(o -> !isNum(o.split(" ")[1]))
                .sorted(this::compareOrders).collect(Collectors.toList());

        primes.addAll(nonPrimes);

        return primes;
    }

    private int compareOrders(String o1, String o2) {
        String[] split1 = o1.split(" ", 2);
        String meta1 = split1[1];
        String id1 = split1[0];

        String[] split2 = o2.split(" ", 2);
        String meta2 = split2[1];
        String id2 = split2[0];

        if (meta1.equals(meta2)) {
            return id1.compareTo(id2);
        }
        return meta1.compareTo(meta2);
    }

    private boolean isNum(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    @Test
    public void testPrioritize() {
        List<String> orders = Arrays.asList("id1 233 232 232", "12d amazon kindle", "13d amazon kindle", "id2 54352 23", "id6 amazon book");

        List<String> actual = prioritize(orders);

        List<String> expected = Arrays.asList("id6 amazon book", "12d amazon kindle", "13d amazon kindle", "id1 233 232 232", "id2 54352 23");
        assertEquals(expected, actual);
    }
}

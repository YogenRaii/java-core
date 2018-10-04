package com.eprogrammerz.examples.algorithm.general;

import java.util.*;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * @author Yogen Rai
 */
public class AnagramMaker {
    public static int makeAnagram(String a, String b) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: a.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        int count = 0;

        for (char ch: b.toCharArray()) {
            if (map.containsKey(ch)) {
                int chCount = map.get(ch) - 1;
                if (chCount == 0) map.remove(ch);
                else map.put(ch,chCount);
            } else {
                count++;
            }
        }

        int remainingCount = map.values().stream().reduce(0, (x,y) -> x+y);

        return count + remainingCount;
    }
}

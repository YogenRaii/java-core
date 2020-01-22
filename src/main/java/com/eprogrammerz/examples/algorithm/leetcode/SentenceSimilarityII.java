package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/sentence-similarity-ii/
 */
public class SentenceSimilarityII {

    // Time O(N * logP)
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {

        if (words1 == null || words2 == null || words1.length != words2.length) return false;

        Map<String, String> parents = new HashMap<>();

        int n = words1.length;

        for (List<String> pair : pairs) {
            String u = pair.get(0);
            String v = pair.get(1);

            if (!parents.containsKey(u)) parents.put(u, u);
            if (!parents.containsKey(v)) parents.put(v, v);

            if (!find(parents, u).equals(find(parents, v))) {
                union(parents, u, v);
            }
        }

        for (int i = 0; i < n; i++) {
            String u = words1[i];
            String v = words2[i];

            if (u.equals(v)) continue;

            if (!parents.containsKey(u) || !parents.containsKey(v) || !find(parents, u).equals(find(parents, v))) {
                return false;
            }
        }

        return true;
    }

    private String find(Map<String, String> parents, String u) {
        while (!u.equals(parents.get(u))) {
            u = parents.get(u);
        }
        return u;
    }

    private void union(Map<String, String> parents, String u, String v) {
        parents.put(find(parents, v), find(parents, u));
    }

    @Test
    public void test() {
        assertTrue(areSentencesSimilarTwo(new String[]{"great", "acting", "skills"}, new String[]{"fine", "drama", "talent"},
                asList(asList("great", "good"), asList("fine", "good"), asList("drama", "acting"), asList("skills", "talent"))));
    }
}

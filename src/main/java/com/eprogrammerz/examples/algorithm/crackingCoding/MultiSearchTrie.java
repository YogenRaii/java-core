package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class MultiSearchTrie {
    Map<String, List<Integer>> searchAll(String[] smalls, String big) {
        Map<String, List<Integer>> map = new HashMap<>();

        Trie trie = createTrieFromString(big);

        for (String small : smalls) {
            List<Integer> locations = trie.search(small);

            // adjust the locations
            List<Integer> adjustedLocations = adjustLocations(locations, small.length());

            map.put(small, adjustedLocations);
        }
        return map;
    }

    private List<Integer> adjustLocations(List<Integer> locations, int delta) {
        if (locations == null) return Collections.emptyList();

        return locations.stream().map(l -> l - delta).collect(Collectors.toList());
    }

    private Trie createTrieFromString(String str) {
        Trie trie = new Trie();
        // populate trie
        for (int i = 0; i < str.length(); i++) {
            String remaining = str.substring(i);
            trie.insertString(remaining, i);
        }

        return trie;
    }

    class Trie {
        private TrieNode root = new TrieNode();

        public Trie() {
        }

        public Trie(String s) {
            this.root.insertString(s, 0);
        }

        public List<Integer> search(String s) {
            return this.root.search(s);
        }

        public void insertString(String str, int location) {
            this.root.insertString(str, location);
        }

        public TrieNode getRoot() {
            return root;
        }
    }

    private class TrieNode {
        char data;
        Map<Character, TrieNode> children;
        List<Integer> indices;

        TrieNode() {
            children = new HashMap<>();
            indices = new ArrayList<>();
        }

        void insertString(String s, int index) {
            indices.add(index);

            if (s != null && s.length() > 0) {
                this.data = s.charAt(0);
                TrieNode child = null;

                if (children.containsKey(data)) {
                    child = children.get(data);
                } else {
                    child = new TrieNode();
                    children.put(data, child);
                }
                String remainder = s.substring(1);
                child.insertString(remainder, index + 1);
            } else {
                children.put('\0', null); // terminate
            }
        }

        List<Integer> search(String s) {
            if (s == null || s.length() == 0) {
                return indices;
            } else {
                char first = s.charAt(0);
                if (children.containsKey(first)) {
                    String remainder = s.substring(1);
                    return children.get(first).search(remainder);
                }
            }
            return null;
        }

        boolean terminates() {
            return children.containsKey('\0');
        }

        TrieNode getChild(char c) {
            return children.get(c);
        }
    }

    @Test
    public void testSearchAll() {
        String[] arr = new String[]{"is", "ppi", "hi", "sis", "i", "ssippi"};
        Map<String, List<Integer>> locations = searchAll(arr, "mississippi"); // {hi=[], ssippi=[5], ppi=[8], i=[1, 4, 7, 10], is=[1, 4], sis=[3]}
        assertEquals(Arrays.asList(1, 4, 7, 10), locations.get("i"));
        assertEquals(Arrays.asList(8), locations.get("ppi"));
    }
}

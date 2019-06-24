package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class MultiSearchTrieBetter {
    public Map<String, List<Integer>> searchAll(String[] smalls, String big) {
        Map<String, List<Integer>> map = new HashMap<>();

        TrieNode root = createTrieFromStrings(smalls).getRoot();

        for (int i = 0; i < big.length(); i++) {
            List<String> strings = findStringAtLoc(root, big, i);
            addStringToMap(strings, i, map);
        }

        return map;
    }

    private void addStringToMap(List<String> strings, int index, Map<String, List<Integer>> map) {
        for (String str : strings) {
            if (map.containsKey(str)) {
                List<Integer> indices = map.get(str);
                indices.add(index);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(index);
                map.put(str, indices);
            }
        }
    }

    private List<String> findStringAtLoc(TrieNode root, String str, int start) {
        List<String> words = new ArrayList<>();

        for (int i = start; i < str.length(); i++) {
            TrieNode child = root.getChild(str.charAt(i));
            if (child == null) break;
            if (child.terminates()) {
                // found string, add to the list
                words.add(str.substring(start, i + 1));
            }
        }
        return words;
    }

    private Trie createTrieFromStrings(String[] smalls) {
        Trie trie = new Trie("");
        for (String small : smalls) {
            trie.insertString(small, 0);
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

        TrieNode() {
            children = new HashMap<>();
        }

        void insertString(String s, int index) {
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

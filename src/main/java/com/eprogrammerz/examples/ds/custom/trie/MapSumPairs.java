package com.eprogrammerz.examples.ds.custom.trie;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


/**
 * https://leetcode.com/problems/map-sum-pairs/
 *
 *
 * Implement a MapSum class with insert, and sum methods.
 *
 * For the method insert, you'll be given a pair of (string, integer).
 * The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair
 * will be overridden to the new one.
 *
 * For the method sum, you'll be given a string representing the prefix,
 * and you need to return the sum of all the pairs' value whose key starts with the prefix.
 *
 * Example 1:
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 */
public class MapSumPairs {
    @Test
    public void test() {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        assertEquals(3, mapSum.sum("ap"));

        mapSum.insert("app", 5);
        assertEquals(8, mapSum.sum("ap"));
    }
}

class MapSum {
    private Trie trie;
    private Map<String, Integer> m;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        this.m = new HashMap<>();
        this.trie = new Trie();
    }

    public void insert(String key, int val) {
        if (!m.containsKey(key)) {
            // put into trie
            this.trie.insert(key);
        }
        m.put(key, val);
    }

    public int sum(String prefix) {
        List<String> words = this.trie.search(prefix);

        int sum = 0;

        for (String word : words) {
            sum += m.get(word);
        }

        return sum;
    }


    class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode('#');
        }

        public void insert(String word) {
            this.root.insert(word);
        }

        public List<String> search(String prefix) {
            TrieNode node = this.root.search(prefix);

            List<String> l = new ArrayList<>();
            if (node == null) return l;

            dfs(node, l, prefix.substring(0, prefix.length() - 1));
            return l;
        }

        private void dfs(TrieNode node, List<String> l, String word) {
            if (node == null) return;
            Map<Character, TrieNode> children = node.children;
            if (children.containsKey('\0')) {
                l.add(word + node.data);
            }

            for (TrieNode child : children.values()) {
                if (child != null && child.data != '\0') {
                    dfs(child, l, word + node.data);
                }
            }
        }
    }

    class TrieNode {
        char data;
        Map<Character, TrieNode> children;

        TrieNode(char data) {
            this.data = data;
            this.children = new HashMap<>();
        }

        public void insert(String word) {
            if (word == null) return;
            if (word.length() == 0) {
                children.put('\0', null);
                return;
            }
            char start = word.charAt(0);
            TrieNode child = null;
            if (children.containsKey(start)) {
                child = children.get(start);
            } else {
                child = new TrieNode(start);
                children.put(start, child);
            }
            child.insert(word.substring(1));
        }

        public TrieNode search(String prefix) {

            if (prefix.length() == 0) return null;

            char start = prefix.charAt(0);
            TrieNode node = null;
            if (children.containsKey(start)) {

                TrieNode child = children.get(start);

                if (prefix.length() == 1) return child;
                node = child.search(prefix.substring(1));
            }
            return node;
        }
    }
}


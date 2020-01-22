package com.eprogrammerz.examples.ds.custom.trie;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * The distance between 2 binary strings is the sum of their lengths after removing the common prefix.
 * For example: the common prefix of 1011000 and 1011110 is 1011 so the distance is len("000") + len("110") = 3 + 3 = 6.
 *
 * Given a list of binary strings, pick a pair that gives you maximum distance among all possible pair and return that distance.
 */
public class MaxDistanceTest {
    @Test
    public void test() {
        assertEquals(6, maxDistance(new String[]{"1011000", "1011110"}));
        assertEquals(9, maxDistance(new String[]{"1011000", "1011110", "1101"}));
        assertEquals(9, maxDistance(new String[]{"1011000", "1011110", "1101", "01"}));
        assertEquals(10, maxDistance(new String[]{"1011000", "1011110", "1101", "011"}));
    }

    public int maxDistance(String[] strs) {
        trie = new Trie();

        for (String str : strs) {
            trie.insert(str);
        }

        return trie.search();
    }

    private Trie trie;

    private class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;

            for (char ch : word.toCharArray()) {
                int val = (ch - '0');

                if (curr.childs[val] == null) {
                    curr.childs[val] = new TrieNode();
                }
                curr = curr.childs[val];
            }
        }

        int max;

        public int search() {
            Set<TrieNode> visited = new HashSet<>();
            dfs(root, visited);
            return max;
        }

        private int dfs(TrieNode node, Set<TrieNode> visited) {
            if (node == null) return 0;
            visited.add(node);

            int l = dfs(node.childs[0], visited);
            int r = dfs(node.childs[1], visited);

            if (node.childs[0] != null && node.childs[1] != null) {
                max = Math.max(max, l + r);
            }
            return Math.max(l, r) + 1;
        }
    }

    private class TrieNode {
        TrieNode[] childs = new TrieNode[2];
    }
}
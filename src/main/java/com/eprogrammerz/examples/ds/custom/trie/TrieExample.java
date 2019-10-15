package com.eprogrammerz.examples.ds.custom.trie;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class TrieExample {
    @Test
    public void test() {
        Trie trie = new Trie();
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));

        trie.insert("app");
        assertTrue(trie.search("app"));

        trie.insert("example");
        trie.insert("elephant");
        trie.insert("ex");

        assertTrue(trie.search("example"));
        assertTrue(trie.startsWith("ele"));
        assertFalse(trie.startsWith("le"));
    }
}

class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('#');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        this.root.insert(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return this.root.search(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return this.root.startsWith(prefix);
    }
}

class TrieNode {
    private char data;
    private Map<Character, TrieNode> children;
    TrieNode(char data) {
        this.data = data;
        this.children = new HashMap<>();
    }

    public boolean startsWith(String word) {
        if (word.isEmpty()) return true;
        char ch = word.charAt(0);
        TrieNode child = children.get(ch);
        if (child == null) return false;
        return child.startsWith(word.substring(1));
    }

    public boolean search(String word) {
        if (word == null) return false;
        if (word.isEmpty() && children.containsKey('\0')) return true;
        if (word.isEmpty()) return false;

        char ch = word.charAt(0);
        TrieNode child = children.get(ch);
        if (child == null) return false;
        return child.search(word.substring(1));
    }

    public void insert(String word) {
        if (word != null && word.length() > 0) {
            char ch = word.charAt(0);
            TrieNode child = children.get(ch);
            if (child == null) {
                child = new TrieNode(ch);
                children.put(ch, child);
            }

            child.insert(word.substring(1));

        } else {
            children.put('\0', null);
        }
    }
}

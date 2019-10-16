package com.eprogrammerz.examples.ds.custom.trie;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 * Example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 */
public class WordDictionaryTest {
    @Test
    public void test1() {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("a");
        dictionary.addWord("a");

        assertTrue(dictionary.search("."));
        assertTrue(dictionary.search("a"));
        assertFalse(dictionary.search("aa"));
        assertTrue(dictionary.search("a"));
        assertFalse(dictionary.search("a."));
        assertFalse(dictionary.search(".a"));

        dictionary.addWord("add");
        assertTrue(dictionary.search("a.d"));
    }

    @Test
    public void test2() {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("at");
        dictionary.addWord("and");
        dictionary.addWord("an");
        dictionary.addWord("add");
        assertFalse(dictionary.search(".at"));
        dictionary.addWord("bat");
        assertTrue(dictionary.search(".at"));
    }
}

class WordDictionary {

    private Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new Node('#');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        root.addWord(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return root.search(word);
    }
}

class Node {
    char data;
    Map<Character, Node> children;
    Node(char data) {
        this.data = data;
        this.children = new HashMap<>();
    }

    void addWord(String word) {
        if (word == null) return;

        if (word.isEmpty()) {
            children.put('\0', null);
            return;
        }

        char ch = word.charAt(0);
        Node child = children.get(ch);
        if (child == null) {
            child = new Node(ch);
            children.put(ch, child);
        }
        child.addWord(word.substring(1));
    }

    boolean search(String word) {
        if (word == null) return false;
        if (word.isEmpty() && children.containsKey('\0')) return true;
        if (word.isEmpty()) return false;
        char ch = word.charAt(0);
        if (ch == '.') {
            boolean has = false;
            for (Node node: children.values()) {
                if (node != null) {
                    has = has || node.search(word.substring(1));
                }
            }
            return has;
        }
        Node child = children.get(ch);
        if (child == null) return false;
        return child.search(word.substring(1));
    }
}
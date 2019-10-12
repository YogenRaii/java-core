package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine
 * if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {

    Trie trie = new Trie();

    public boolean wordBreak(String s, List<String> wordDict) {
        for (String word : wordDict) {
            trie.insert(word);
        }
        Node root = trie.root;

        return wordBreak(s, root);
    }

    private boolean wordBreak(String s, Node node) {
        if ((s == null || s.isEmpty()) && node.terminates()) return true;
        else if (s == null || s.isEmpty()) return false;

        Node child = node.getChild(s.charAt(0));
        if (child != null && child.terminates()) {
            return wordBreak(s.substring(1), trie.root) || wordBreak(s.substring(1), child);
        } else if (child != null) {
            return wordBreak(s.substring(1), child);
        } else {
            return node.terminates() && wordBreak(s, trie.root);
        }
    }

    @Test
    public void test1() {
        assertTrue(wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    @Test
    public void test2() {
        assertTrue(wordBreak("leetscode", Arrays.asList("leet", "leets", "code")));
    }

    @Test
    public void test3() {
        assertFalse(wordBreak("leetcode", Arrays.asList("leets", "code")));
    }

    @Test
    public void test4() {
        assertTrue(wordBreak("bb", Arrays.asList("a", "b", "bbb", "bbbbb")));
    }
}

class Trie {
    Node root = new Node('#');

    void insert(String word) {
        root.insert(word);
    }
}

class Node {
    private char data;
    Map<Character, Node> children;

    Node(char data) {
        this.data = data;
        this.children = new HashMap<>();
    }

    void insert(String word) {
        if (word != null && !word.isEmpty()) {
            this.data = word.charAt(0);
            Node child = children.get(this.data);
            if (child == null) {

                child = new Node(this.data);
                children.put(this.data, child);

            }
            child.insert(word.substring(1));
        } else {
            children.put('\0', null);
        }
    }


    boolean terminates() {
        return children.containsKey('\0');
    }

    Node getChild(char ch) {
        return children.get(ch);
    }
}

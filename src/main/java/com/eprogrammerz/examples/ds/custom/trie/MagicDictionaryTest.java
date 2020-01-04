package com.eprogrammerz.examples.ds.custom.trie;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class MagicDictionaryTest {
    @Test
    public void test1() {
        MagicDictionary dictionary = new MagicDictionary();
        dictionary.buildDict(new String[] {"hello", "leetcode"});

        assertFalse(dictionary.search("hello"));
        assertTrue(dictionary.search("hhllo"));
        assertFalse(dictionary.search("hell"));
        assertFalse(dictionary.search("leetcoded"));
    }
}

class MagicDictionary {
    private Trie trie;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.trie = new Trie();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String str: dict) {
            trie.insert(str);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return trie.search(word);
    }


    class Trie {
        TrieNode root;
        Trie() {
            this.root = new TrieNode();
        }

        void insert(String str) {
            TrieNode curr = root;

            for (char ch: str.toCharArray()) {
                if (curr.child[ch - 'a'] == null) {
                    curr.child[ch - 'a'] = new TrieNode();
                }
                curr = curr.child[ch - 'a'];
            }
            curr.isWord = true;
        }

        boolean search(String str) {
            char[] arr = str.toCharArray();

            for (int i = 0; i < arr.length; i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == arr[i]) continue;

                    char org = arr[i];
                    arr[i] = ch;

                    if (helper(new String(arr))) {
                        return true;
                    }
                    arr[i] = org;
                }
            }
            return false;
        }

        boolean helper(String str) {
            TrieNode curr = root;

            for (char ch: str.toCharArray()) {
                if (curr.child[ch - 'a'] == null) return false;
                curr = curr.child[ch - 'a'];
            }
            return curr.isWord;
        }


        class TrieNode {
            boolean isWord;
            TrieNode[] child;
            TrieNode() {
                this.child = new TrieNode[26];
            }
        }
    }


}

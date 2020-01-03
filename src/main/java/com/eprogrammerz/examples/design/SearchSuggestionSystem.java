package com.eprogrammerz.examples.design;

import org.junit.Test;

import java.util.*;

import static java.util.Arrays.asList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * https://leetcode.com/problems/search-suggestions-system/
 */
public class SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();

        Arrays.sort(products);

        for (String product: products) {
            trie.insert(product);
        }

        List<List<String>> l = new ArrayList<>();

        for (int i = 0; i <= searchWord.length(); i++) {
            trie.search(searchWord.substring(0, i), l);
        }

        return l;
    }

    class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode('#');
        }


        public void insert(String word) {

            TrieNode curr = root;

            for (char ch: word.toCharArray()) {
                if (curr.child[ch - 'a'] == null) {
                    curr.child[ch - 'a'] = new TrieNode(ch);
                }
                curr = curr.child[ch - 'a'];
                curr.words.add(word);
            }
        }

        public void search(String str, List<List<String>> l) {
            if (str.length() == 0) return;
            TrieNode curr = root;
            for (char ch: str.toCharArray()) {
                if (curr.child[ch - 'a'] == null) {
                    l.add(new ArrayList<>());
                    return;
                } else {
                    curr = curr.child[ch - 'a'];

                }
            }


            List<String> suggestions = new ArrayList<>();
            for (int i = 0; i < curr.words.size() && i < 3; i++) {
                suggestions.add(curr.words.get(i));
            }
            l.add(suggestions);
        }
    }
    class TrieNode {
        char val;
        TrieNode[] child;
        List<String> words;

        TrieNode(char val) {
            this.val = val;
            this.child = new TrieNode[26];
            this.words = new LinkedList<>();
        }
    }

    @Test
    public void test() {
        List<List<String>> expected = asList(asList("mobile","moneypot","monitor"),
                asList("mobile","moneypot","monitor"), asList("mouse","mousepad"),
                asList("mouse","mousepad"), asList("mouse","mousepad"));
        assertThat(suggestedProducts(new String[] {"mobile","mouse","moneypot","monitor","mousepad"} , "mouse"), is(expected));
    }
}

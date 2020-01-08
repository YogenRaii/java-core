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

        for (String product: products) {
            trie.insert(product);
        }

        List<List<String>> l = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) {
            l.add(trie.search(searchWord.substring(0, i)));
        }

        return l;
    }

    class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }


        public void insert(String word) {

            TrieNode curr = root;

            List<TrieNode> visited = new ArrayList<>();

            for (char ch: word.toCharArray()) {
                if (curr.child[ch - 'a'] == null) {
                    curr.child[ch - 'a'] = new TrieNode();
                }
                curr = curr.child[ch - 'a'];

                visited.add(curr);
            }

            for (TrieNode node: visited) {
                node.updateTop(word);
            }
        }

        public List<String> search(String str) {
            if (str.length() == 0) return Collections.emptyList();
            TrieNode curr = root;
            for (char ch: str.toCharArray()) {
                if (curr.child[ch - 'a'] == null) {
                    return Collections.emptyList();
                } else {
                    curr = curr.child[ch - 'a'];

                }
            }

            return new LinkedList<>(curr.top);
        }
    }
    class TrieNode {
        TrieNode[] child;
        LinkedList<String> top;

        TrieNode() {
            this.child = new TrieNode[26];
            this.top = new LinkedList<>();
        }

        public void updateTop(String word) {
            if (!top.contains(word)) {
                top.add(word);
            }

            top.sort(Comparator.naturalOrder());

            if (top.size() > 3) {
                top.removeLast();
            }
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

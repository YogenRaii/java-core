package com.eprogrammerz.examples.design;

import org.junit.Test;

import java.util.*;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * https://leetcode.com/problems/design-search-autocomplete-system/
 */

public class AutoCompleteSystemTest {
    @Test
    public void test() {
        String[] sentences = {"i love you", "island","ironman", "i love leetcode"};
        int[] times = {5,3,2,2};

        AutocompleteSystem system = new AutocompleteSystem(sentences, times);

        assertThat(system.input('i'), is(asList("i love you", "island", "i love leetcode")));
        assertThat(system.input(' '), is(asList("i love you", "i love leetcode")));
        assertThat(system.input('a'), is(asList()));
        assertThat(system.input('#'), is(asList()));
    }
}


class AutocompleteSystem {

    private Trie trie;

    private StringBuilder curr;
    public AutocompleteSystem(String[] sentences, int[] times) {
        this.curr = new StringBuilder();
        this.trie = new Trie();

        int n = sentences.length;

        for (int i = 0; i < n; i++) {
            this.trie.insert(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {

        if (c == '#') {
            trie.insert(curr.toString(), 1);
            curr = new StringBuilder();

            return Collections.emptyList();
        } else {
            curr.append(c);
        }

        return this.trie.search(curr.toString());
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String str, int count) {
        TrieNode curr = root;

        List<TrieNode> visited = new ArrayList<>();

        for (char ch: str.toCharArray()) {
            if (curr.childs[ch] == null) {
                curr.childs[ch] = new TrieNode();
            }
            curr = curr.childs[ch];
            visited.add(curr);

        }

        curr.times += count;
        curr.sentence = str;

        for (TrieNode node: visited) {
            node.update(curr);
        }

    }

    public List<String> search(String str) {
        LinkedList<String> l = new LinkedList<>();

        TrieNode curr = root;
        for (char ch: str.toCharArray()) {
            if (curr.childs[ch] == null) return l;
            curr = curr.childs[ch];
        }

        if (curr == null) return l;

        LinkedList<TrieNode> top = curr.top;

        for (TrieNode hot: top) {
            l.add(hot.sentence);
        }

        return l;
    }
}

class TrieNode implements Comparable<TrieNode> {
    TrieNode[] childs;
    String sentence;
    int times;

    LinkedList<TrieNode> top;

    public TrieNode() {
        this.childs = new TrieNode[128];

        this.top = new LinkedList<>();
    }

    @Override
    public int compareTo(TrieNode that) {
        int diff = that.times - this.times;
        if (diff == 0) {
            return this.sentence.compareTo(that.sentence);
        }
        return diff;
    }

    public void update(TrieNode node) {
        if (!top.contains(node)) {
            top.add(node);
        }

        Collections.sort(top);

        if (top.size() > 3) top.removeLast();
    }

}

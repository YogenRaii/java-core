package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

import static java.util.Arrays.asList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * https://leetcode.com/problems/word-ladder-ii/
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> l = new ArrayList<>();
        if (!wordList.contains(endWord)) return l;

        Map<String, List<String>> graph = new HashMap<>();

        Set<String> startSet = new HashSet<>();
        startSet.add(beginWord);

        Set<String> dict = new HashSet<>(wordList);

        // to build the graph -> directed graph
        bfs(startSet, endWord, graph, dict);


        List<String> temp = new ArrayList<>();
        temp.add(beginWord);

        // backtrack to create the result ladder
        dfs(beginWord, endWord, l, graph, temp);

        return l;
    }

    private void bfs(Set<String> startSet, String endWord, Map<String, List<String>> graph, Set<String> dict) {
        if (startSet.isEmpty()) return; // no more graph building

        Set<String> temp = new HashSet<>();

        boolean finish = false;

        dict.removeAll(startSet);

        for (String word : startSet) {
            char[] chars = word.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char old = chars[i];

                // change each char and see if we have a word in dict
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;

                    String next = new String(chars);

                    if (dict.contains(next)) {
                        if (next.equals(endWord)) {
                            finish = true;
                        } else {
                            temp.add(next);
                        }

                        graph.computeIfAbsent(word, s -> new ArrayList<>()).add(next);
                    }

                }
                chars[i] = old;
            }
        }

        if (!finish) bfs(temp, endWord, graph, dict);
    }

    private void dfs(String beginWord, String endWord, List<List<String>> l, Map<String, List<String>> graph, List<String> temp) {
        if (endWord.equals(beginWord)) {
            l.add(new ArrayList<>(temp));

            return;
        }

        if (graph.containsKey(beginWord)) {
            for (String word : graph.get(beginWord)) {

                temp.add(word);
                dfs(word, endWord, l, graph, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        assertThat(findLadders("hot", "dog", Arrays.asList("hot", "dog")), is(Collections.emptyList()));

        assertThat(findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")),
                is(asList(asList("hit","hot","dot","dog","cog"), asList("hit","hot","lot","log","cog"))));
    }
}

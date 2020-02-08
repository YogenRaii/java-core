package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/longest-absolute-file-path/
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int len = 0;

        for (String str: input.split("\n")) {
            int level = str.lastIndexOf("\t") + 1;

            while (level + 1 < stack.size()) stack.pop();

            int curr = stack.peek() + str.length() - level + 1; // remove /t, add /
            stack.push(curr);

            if (str.contains(".")) len = Math.max(len, curr - 1);
        }

        return len;
    }

    @Test
    public void test() {
        assertEquals(0, lengthLongestPath("file"));
        assertEquals(12, lengthLongestPath("dir\n    file.txt"));
        assertEquals(20, lengthLongestPath("dir\n\t        file.txt\n\tfile2.txt"));
        assertEquals(25, lengthLongestPath("file name with  space.txt"));
        assertEquals(8, lengthLongestPath("file.txt"));
        assertEquals(0, lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tsubdir3"));
        assertEquals(16, lengthLongestPath("dir\n        file.txt"));
        assertEquals(20, lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        assertEquals(20, lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        assertEquals(32, lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }
}

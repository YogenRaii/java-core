package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * https://leetcode.com/problems/remove-comments/
 */
public class RemoveComments {
    public List<String> removeComments(String[] source) {
        // read each line and look for '/' char
        // look for next char
        // if '/', then remove all the strings remaing to end of line
        // if '*', then keep on moving until you find '*/'
        List<String> l = new ArrayList<>();
        if (source == null || source.length == 0) return l;
        boolean open = false;

        StringBuilder sb = new StringBuilder();

        for (String line: source) {

            if (!open)
                sb = new StringBuilder();

            int i = 0;
            while (i < line.length()) {
                if (!open && line.charAt(i) == '/' && i + 1 < line.length() && line.charAt(i + 1) == '*') {
                    open = true;
                    i++;
                } else if (open && line.charAt(i) == '*' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                    open = false;
                    i++;
                } else if (!open && line.charAt(i) == '/' && i + 1 < line.length() && line.charAt(i + 1) == '/') { // we can skip content after //
                    break;
                } else if (!open) {
                    sb.append(line.charAt(i));
                }
                i++;
            }

            if (sb.length() > 0 && !open)
                l.add(sb.toString());
        }
        return l;
    }

    @Test
    public void test1() {
        List<String> expected = asList("int main()","{ ","  ","int a, b, c;","a = b + c;","}");
        String[] input = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        assertThat(removeComments(input), is(expected));
    }

    @Test
    public void test2() {
        List<String> expected = asList("ab");
        String[] input = {"a/*comment", "line", "more_comment*/b"};
        assertThat(removeComments(input), is(expected));
    }

    @Test
    public void test3() {
        List<String> expected = asList("main() {","   double s = 33;","   cout << s;","}");
        String[] input = {"main() {", "/* here is commments", "  // still comments */", "   double s = 33;", "   cout << s;", "}"};
        assertThat(removeComments(input), is(expected));
    }
}

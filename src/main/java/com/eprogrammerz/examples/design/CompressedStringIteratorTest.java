package com.eprogrammerz.examples.design;

import org.junit.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/design-compressed-string-iterator/
 */
public class CompressedStringIteratorTest {
    @Test
    public void test() {
        StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

        assertEquals('L', iterator.next());
        assertEquals('e', iterator.next());
        assertEquals('e', iterator.next());
        assertEquals('t', iterator.next());
        assertEquals('C', iterator.next());
        assertEquals('o', iterator.next());
        assertEquals('d', iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals('e', iterator.next());
        assertFalse(iterator.hasNext());
        assertEquals(' ', iterator.next());
        iterator.next(); // return 'e'
    }
}

class StringIterator {

    private String compressed;
    private char curr;
    private int count;
    private int i = 0;

    public StringIterator(String compressedString) {
        this.compressed = compressedString;

        set();
    }

    private void set() {
        if (i == compressed.length()) return;

        curr = compressed.charAt(i);
        i++;
        for (; i < compressed.length(); i++) {
            char digit = compressed.charAt(i);
            if ('0' <= digit && digit <= '9') {
                count = count * 10 + (digit - '0');
            } else {
                break;
            }
        }
    }

    public char next() {
        if (!hasNext()) return ' ';

        char ans = curr;
        count--;
        if (count == 0) {
            set();
        }

        return ans;
    }

    public boolean hasNext() {
        if (i == compressed.length()) return count > 0;
        return true;
    }
}

package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Yogen on 9/29/2017.
 */
public class ParenthesesValidator {
    @Test
    public void testIsValid() {
        assertFalse(isValid("{]"));
        assertTrue(isValid("{}[]"));
        assertTrue(isValid("{([])}"));
    }
    
    
    public static boolean isValid(String s) {
        Map<Character, Character> pairs = new HashMap<Character, Character>() {
            {
                put('(', ')');
                put('[', ']');
                put('{', '}');
            }
        };

        if(!pairs.containsKey(s.charAt(0)) || pairs.containsKey(s.charAt(s.length() - 1)) || s.length() %2 != 0) {
            return false;
        }

        Stack<Character> charStack = new Stack<>();

        for(char ch: s.toCharArray()) {
            if(pairs.containsKey(ch)) {
                charStack.push(pairs.get(ch));
            } else {
                if(charStack.isEmpty() || charStack.pop() != ch) {
                    return false;
                }
            }
        }

        return charStack.isEmpty();
    }
}

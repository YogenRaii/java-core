package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.assertTrue;

/**
 * @author Yogen Rai
 */
public class BalancedBracket {
    public static boolean isBalanced(String brackets) {
        // set matching pairs
        Map<Character, Character> braces = new HashMap<>();
        braces.put('(', ')');
        braces.put('[',']');
        braces.put('{','}');

        // if length of string is odd, then it is not balanced
        if (brackets.length() % 2 != 0) {
            return false;
        }

        // travel half until openings are found and compare with
        // remaining if the closings matches
        Stack<Character> halfBraces = new Stack();
        for(char ch: brackets.toCharArray()) {
            if (braces.containsKey(ch)) {
                halfBraces.push(braces.get(ch));
            }
            // if stack is empty or if closing bracket is not equal to top of stack,
            // then braces are not balanced
            else if(halfBraces.isEmpty() || ch != halfBraces.pop()) {
                return false;
            }
        }
        return halfBraces.isEmpty();
    }

    @Test
    public void testIsBalanced() {
        assertTrue(isBalanced("{[()]}"));
    }
}

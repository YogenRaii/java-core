package com.eprogrammerz.examples.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Yogen on 9/29/2017.
 */
public class ParenthesesValidator {
    public static void main(String[] args) {
        System.out.println(isValid("{]"));
        System.out.println(isValid("{}[]"));
        System.out.println(isValid("{([])}"));
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

        return charStack.size() == 0;
    }
}

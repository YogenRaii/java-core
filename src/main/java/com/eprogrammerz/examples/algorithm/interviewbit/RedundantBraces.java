package com.eprogrammerz.examples.algorithm.interviewbit;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Write a program to validate if the input string has redundant braces?
 * Return 0/1
 *
 * 0 -> NO
 * 1 -> YES
 * Input will be always a valid expression
 *
 * and operators allowed are only + , * , - , /
 *
 * Example:
 *
 * ((a + b)) has redundant braces so answer will be 1
 * (a + (a + b)) doesn't have have any redundant braces so answer will be 0
 *
 *
 *
 * ((a+b)+c)
 *
 * IDEA: operand has to be there in order to have no redundant braces
 *
 * push until ) is encountered
 * pop until opening is encountered for recent )
 * if immediate pop encounters another opening, then it is redundant
 */
public class RedundantBraces {
    public int braces(String str) {
        ImmutableSet<Character> operands = ImmutableSet.of('+','*','-','/');

        Stack<Character> stack = new Stack<>();

        for (char ch: str.toCharArray()) {
            if (ch == ')') {
                char last = stack.pop();

                boolean operandFlag = true;

                while (last != '(') {

                    if (operands.contains(last)) {
                        operandFlag = false;
                    }

                    last = stack.pop();
                }

                if (operandFlag) return 1;
            } else {
                stack.push(ch);
            }
        }

        return 0;
    }

    @Test
    public void testBraces() {
        assertEquals(1, braces("((a + b))"));
        assertEquals(0, braces("(a+(a+b))"));
        assertEquals(0, braces("(a + (a + b))"));
        assertEquals(0, braces("((a + b) + b)"));
    }
}

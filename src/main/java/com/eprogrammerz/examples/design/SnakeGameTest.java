package com.eprogrammerz.examples.design;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/design-snake-game/
 */

public class SnakeGameTest {
    @Test
    public void test() {
        SnakeGame game = new SnakeGame(2,2, new int[][] {{1,1}, {0,0}});

        assertEquals(0, game.move("R"));
        assertEquals(1, game.move("D"));
        assertEquals(1, game.move("L"));
        assertEquals(2, game.move("U"));
        assertEquals(2, game.move("R"));
    }
}

class SnakeGame {

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    // q to track co-ordinates
    // add when going to new cell, and poll

    private int r;
    private int c;

    private int score;
    private int[][] food;
    private Deque<int[]> curr;

    public SnakeGame(int width, int height, int[][] food) {
        this.r = height;
        this.c = width;
        this.food = food;

        this.curr = new ArrayDeque<>();
        this.curr.addFirst(new int[] {0, 0});

    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
     @return The game's score after the move. Return -1 if game over. 
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] head = curr.getFirst();

        int row = head[0];
        int col = head[1];

        switch(direction) {
            case "U":
                row--;
                break;
            case "L":
                col--;
                break;
            case "R":
                col++;
                break;
            case "D":
                row++;
                break;
        }

        if (row == r || row < 0 || col == c || col < 0) return -1;

        if (score < food.length && row == food[score][0] && col == food[score][1]) {
            score++;
        } else {

            // update snake
            curr.removeLast();
        }

        if (isPartOfSnake(row, col)) return -1;

        curr.addFirst(new int[] {row, col});

        return score;
    }

    private boolean isPartOfSnake(int row, int col) {
        Iterator<int[]> itr = curr.iterator();

        while (itr.hasNext()) {
            int[] p = itr.next();
            if (row == p[0] && col == p[1]) return true;
        }

        return false;
    }
}
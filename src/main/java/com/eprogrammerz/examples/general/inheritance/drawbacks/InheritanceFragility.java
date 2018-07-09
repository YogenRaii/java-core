package com.eprogrammerz.examples.general.inheritance.drawbacks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yogen on 3/2/2017.
 */
public class InheritanceFragility {

    @Test
    public void testSquare() {
        Square square = new Square(5);
        assertEquals("Area of square", 25, square.calculateArea());

        // set breadth of square :(
        square.setBreadth(9);
//        assertEquals("Area of new square", 81, square.calculateArea()); // fails
    }
}

class Square extends Rectangle {
    public Square(int side) {
        super(side, side);
    }
}

class Rectangle {
    private int length;
    private int breadth;

    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public int calculateArea() {
        return length * breadth;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }
}
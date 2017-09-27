package com.eprogrammerz.examples.general.inheritance.drawbacks;

/**
 * Created by 542596 on 3/2/2017.
 */
public class InheritanceFragality {

    public static void main(String[] args) {
        Square square = new Square(5);
        System.out.println(square.calculateArea());  //25

        square.setBreadth(9);
        System.out.println(square.calculateArea());   //45 which is not correct for square
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
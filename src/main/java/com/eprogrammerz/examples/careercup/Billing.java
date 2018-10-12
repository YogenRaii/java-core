package com.eprogrammerz.examples.careercup;

import org.junit.Test;

import java.text.DecimalFormat;

import static junit.framework.TestCase.assertTrue;

public class Billing {

    public static void main(String args[]) {
        double yourTotal;
        yourTotal = computeBill(31.00);
        displayTotal(yourTotal);
        yourTotal = computeBill(31, 2);
        System.out.println(yourTotal);
        displayTotal(yourTotal);
        yourTotal = computeBill(31, 2, .2);
        displayTotal(yourTotal);
    }

    public static double computeBill(double price) {
        double total = price * 1.08;
        System.out.println("You ordered 1 photobook for $" + price);
        System.out.println("Plus sales tax 8%");
        return total;
    }

    public static double computeBill(double price, int qty) {
        double subtotal = price * qty;
        double total = subtotal * 1.08;
        System.out.println("You ordered" + qty + " photobook(s) for $" + price);
        System.out.println("Subtotal =" + subtotal);
        System.out.println("Plus sales tax 8%");

        return Double.parseDouble(new DecimalFormat("##.##").format(total));
    }

    public static double computeBill(double price, int qty, double discount) {
        double subtotal = price * qty;
        subtotal = subtotal - (subtotal * discount);
        double total = subtotal * 1.08;
        System.out.println("You ordered " + qty + " photobook(s) for $" + price);
        System.out.println("Subtotal = " + subtotal);
        System.out.println("Less your " + (discount * 100) + "% discount");
        System.out.println("Plus sales tax 8%");
        return total;
    }

    public static void displayTotal(double total) {
        System.out.println("Total: $" + total);
    }

    @Test
    public void unitTest() {
        assertTrue(computeBill(31, 2) == 66.96);
    }


}

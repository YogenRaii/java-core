package com.eprogrammerz.examples.ds.custom.linkedList;

import org.junit.Test;

public class SumList {
    private Node sumList(Node h1, Node h2) {
        Node result = null;

        Node carrier = null;

        int carry = 0;

        while (h1 != null || h2 != null || carry > 0) {
            int sum = carry;

            if (h1 != null) {
                sum += h1.data;
                h1 = h1.next;
            }

            if (h2 != null) {
                sum += h2.data;
                h2 = h2.next;
            }

            if (sum > 9) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            Node node = new Node(sum);

            if (result == null) {
                result = node;
                carrier = result;
            } else {
                carrier.next = node;
                carrier = carrier.next;
            }
        }

        return result;
    }

    @Test
    public void testSumList() {
        // 617
        // presented in reverse order 7 -> 1 -> 6
        Node n1 = new Node(7);
        Node n2 = new Node(1);
        Node n3 = new Node(6);
        n1.next = n2;
        n2.next = n3;

        // 295
        // 5 -> 9 -> 2
        Node na = new Node(5);
        Node nb = new Node(9);
        Node nc = new Node(2);
        na.next = nb;
        nb.next = nc;

        Node sum = sumList(n1, na); // 912

        while (sum != null) {
            System.out.print(sum.data);
            sum = sum.next;
        }
        // prints 219
    }
}

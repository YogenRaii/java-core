package com.eprogrammerz.examples.ds.custom.linkedList;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "(" + val + ")";
    }
}
package com.eprogrammerz.examples.ds.custom.linkedList;

public class ListUtil {

    public static String printList(ListNode res) {
        StringBuilder sb = new StringBuilder();
        if (res == null) return sb.toString();

        while (res.next != null) {
            sb.append(res.val);
            sb.append(" -> ");
            res = res.next;
        }
        sb.append(res.val);
        return sb.toString();
    }
}

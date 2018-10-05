package com.eprogrammerz.examples.careercup;

import java.util.*;

/**
 * @author Yogen Rai
 *
Group orders by items present in the orders.

Class Order{
String orderId;
List<String> items;
}

Given Order id and items:

O1: [A, B]
O2: [B, C]
O3: [D, E]

Output: [[O1, O2], [O3]]

Note: There can be more that 2 items in an order.

List<List<String>> implementhis(List<Order> orders){
}


Solution:
Item-to-index
 A : 0
 B : 0
 B : 0
 C : 0
 D : 1
 E : 1

 index-to-list
 0 - [O1,O2]
 1- [O3]
 */
public class GroupOrders {
    public static List<List<String>> groupOrders(List<Order> orders) {
        Map<String, Integer> itemToIndex = new HashMap<>();
        List<List<String>> ordersList = new LinkedList<>();

        for (Order order: orders) {
            String matchingItem = null;
            for (String item: order.items) {
                if (itemToIndex.containsKey(item)) {
                    matchingItem = item;
                    break;
                }
            }

            if (matchingItem != null) {
                int index = itemToIndex.get(matchingItem);
                // update orders
                List<String> existingOrders = ordersList.get(index);
                existingOrders.add(order.orderId);

                // update index for all items in this order
                for (String item: order.items) {
                    itemToIndex.put(item, index);
                }
            } else {
                // update index for all items in this order
                for (String item: order.items) {
                    itemToIndex.put(item, ordersList.size());
                }

                List<String> singleRes = new ArrayList<>();
                singleRes.add(order.orderId);
                ordersList.add(singleRes);
            }
        }
        return ordersList;
    }

    static class Order {
        String orderId;
        List<String> items;

        public Order(String orderId, List<String> items) {
            this.orderId = orderId;
            this.items = items;
        }
    }

    public static void main(String[] args) {
        Order o1 = new Order("O1", Arrays.asList("A", "B"));
        Order o2 = new Order("O2", Arrays.asList("B", "C"));
        Order o3 = new Order("O3", Arrays.asList("D", "E"));
        Order o4 = new Order("O4", Arrays.asList("F", "G"));
        Order o5 = new Order("O5", Arrays.asList("H", "D"));
        List<Order> orders = Arrays.asList(o1, o2, o3, o4, o5);

        List<List<String>> groupOrder = groupOrders(orders);

        System.out.println(groupOrder); //[[O1, O2], [O3, O5], [O4]]
    }
}

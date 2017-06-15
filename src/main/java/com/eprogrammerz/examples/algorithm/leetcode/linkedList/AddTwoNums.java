/**
 * 
 */
package com.eprogrammerz.examples.algorithm.leetcode.linkedList;

/**
 * @author Yogen
 *
 */
public class AddTwoNums {
	public static void main(String... args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(9);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = addTwoNumbers(l1, l2);
		
		System.out.print("(");
		print(l1);
		System.out.print(") + (");
		print(l2);
		System.out.print(")");
		System.out.println();
		print(l3);
	}
	/**
	 * @param l1
	 */
	private static void print(ListNode l) {
		while(l != null) {
			System.out.print(l);
			l = l.next;
		}
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		int carry = 0;
		int sum = l1.val + l2.val;
		l1 = l1.next;
		l2 = l2.next;
		
		if(sum >= 10) {
			sum= sum % 10;
			carry = 1;
		} 
		ListNode result = new ListNode(sum);
		
		ListNode last = result;
		
		while(l1 != null && l2 != null) {
			sum = l1.val + l2.val + carry;
			l1 = l1.next;
			l2 = l2.next;
			if(sum >= 10) {
				sum = sum % 10;
				carry = 1;
			} else {
				carry = 0;
			}
			ListNode node = new ListNode(sum);
			last.next = node;
			last = last.next;
		}
		
		if(l1 == null) {
			while(l2 != null) {
				sum = l2.val + carry;
				l2 = l2.next;
				if(sum >= 10) {
					sum = sum % 10;
					carry = 1;
				} else {
					carry = 0;
				}
				ListNode node = new ListNode(sum);
				last.next = node;
				last = last.next;
			}
		} else {
			while(l1 != null) {
				sum = l1.val + carry;
				l1 = l1.next;
				if(sum >= 10) {
					sum = sum % 10;
					carry = 1;
				} else {
					carry = 0;
				}
				ListNode node = new ListNode(sum);
				last.next = node;
				last = last.next;
			}
		}
		
		if(carry != 0) {
			last.next = new ListNode(carry);
		}
		return result;
	}

}

class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x) { val = x; }
	
	@Override
	public String toString() {
		return val + ((next == null) ? "" : "->");
	}
}

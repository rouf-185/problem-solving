package leetcode.meta.add_two_numbers_2;
import java.util.*;

class ListNode {
  	public int val;
	public ListNode next;
	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}



public class Solution {
	private ListNode reverseList(ListNode head) {
		ListNode newHead = null;
		ListNode itrNode = head;
		while(itrNode != null) {
			ListNode newNode = new ListNode(itrNode.val, null);
			newNode.next = newHead != null ? newHead : null;
			newHead = newNode;
			itrNode = itrNode.next;
		}
		return newHead;
	} 
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode itrNode1 = l1;
		ListNode itrNode2 = l2;
		int carryIn = 0;
		while(itrNode1 != null | itrNode2 != null) {
			int sum = 0;
			if(itrNode1 == null) {
				sum += itrNode2.val + carryIn;
				itrNode2 = itrNode2.next;
			} else if(itrNode2 == null) {
				sum += itrNode1.val + carryIn;
				itrNode1 = itrNode1.next;
			} else {
				sum += itrNode1.val + itrNode2.val + carryIn;
				itrNode1 = itrNode1.next;
				itrNode2 = itrNode2.next;
			}
			ListNode newNode = new ListNode(sum % 10; null);
			newNode.next = head != null ? head : null;
			head = newNode;
			carryIn = sum / 10;
		}
		if(carryIn > 0) {
			ListNode newNode = new ListNode(carryIn; null);
			newNode.next = head != null ? head : null;
			head = newNode;
		}	
		return reverseList(head);
	}
}


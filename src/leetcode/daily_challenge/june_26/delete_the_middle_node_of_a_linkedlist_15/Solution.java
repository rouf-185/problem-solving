package leetcode.daily_challenge.june_26.delete_the_middle_node_of_a_linkedlist_15;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
public class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) {
            return null;
        }
        ListNode slowPrev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(true) {
            if(fast == null || fast.next == null) {
                slowPrev.next = slow.next;
                break;
            }
            fast = fast.next.next;
            slowPrev = slow;
            slow = slow.next;
        }
        return head;
    }
}

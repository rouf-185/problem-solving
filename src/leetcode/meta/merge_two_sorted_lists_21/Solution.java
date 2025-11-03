package leetcode.meta.merge_two_sorted_lists_21;

class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode itrNode = dummyHead;
        while(list1 != null || list2 != null) {
            if(list1 != null && list2 != null) {
                if(list1.val <= list2.val) {
                    itrNode.next = list1;
                    list1 = list1.next;
                } else {
                    itrNode.next = list2;
                    list2 = list2.next;
                }
            } else if(list1 != null) {
                itrNode.next = list1;
                list1 = list1.next;
            } else {
                itrNode.next = list2;
                list2 = list2.next;
            }
            itrNode = itrNode.next;
        }
        return dummyHead.next;
    }
}

package leetcode.meta.merge_two_sorted_lists_21;


public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        } else if(list1 != null) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else if(list2 != null) {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        } else {
            return null;
        }
    }
}

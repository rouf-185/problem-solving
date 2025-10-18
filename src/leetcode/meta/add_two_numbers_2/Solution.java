
package leetcode.meta.add_two_numbers_2;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0, null);
        int carryIn = 0;
        ListNode itrNode = dummyHead;
        while(l1 != null || l2 != null || carryIn > 0) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carryIn;
            itrNode.next = new ListNode(sum % 10, null);
            itrNode = itrNode.next;
            carryIn = sum / 10;
            l1 = l1 != null ?  l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        return dummyHead.next;
    }
}

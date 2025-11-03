package leetcode.meta.palindrome_linked_list_234;

public class SolutionV2 {
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currNext;
        }
        head = prev;
        return head;
    }
    private ListNode findLastNodeOfFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode lastNode = findLastNodeOfFirstHalf(head);
        if(lastNode == null) {
            return true;
        }
        ListNode reverseHead = reverseList(lastNode.next);
        lastNode.next = null;
        ListNode itr1 = head;
        ListNode itr2 = reverseHead;
        while(itr2 != null) {
            if(itr1.val != itr2.val) {
                lastNode.next = reverseList(reverseHead);
                return false;
            }
            itr1 = itr1.next;
            itr2 = itr2.next;
        }
        reverseHead = reverseList(reverseHead);
        lastNode.next = reverseHead;
        return true;
    }
}

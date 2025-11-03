package leetcode.meta.palindrome_linked_list_234;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode itr = head;
        while(itr != null) {
            stack.push(itr);
            itr = itr.next;
        }
        itr = head;
        while(itr != null) {
            if(itr.val != stack.pop().val) {
                return false;
            }
            itr = itr.next;
        }
        return true;
    }
}

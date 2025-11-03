package leetcode.meta.palindrome_linked_list_234;

public class SolutionV1 {
    private ListNode itr; 
    private boolean recurse(ListNode node){
        if(node == null) {
            return true;
        }
        boolean decision = recurse(node.next) && (itr.val == node.val);
        itr = itr.next;
        return decision;
    }
    public boolean isPalindrome(ListNode head) {
        this.itr = head;
        return recurse(head);
    }
}

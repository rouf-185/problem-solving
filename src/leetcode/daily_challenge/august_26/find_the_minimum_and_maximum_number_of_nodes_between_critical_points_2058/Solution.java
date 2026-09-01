package leetcode.daily_challenge.august_26.find_the_minimum_and_maximum_number_of_nodes_between_critical_points_2058;

public class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode curr = head.next;
        ListNode prev = head;
        int idx = 1;
        int firstCriticalIdx = -1;
        int prevCriticalIdx = -1;
        int min = Integer.MAX_VALUE;
        while(curr.next != null) {
            if((curr.val > curr.next.val && curr.val > prev.val) || (curr.val < curr.next.val && curr.val < prev.val)) {
                if(prevCriticalIdx != -1) {
                    min = Math.min(idx - prevCriticalIdx, min);
                }
                firstCriticalIdx = firstCriticalIdx == -1 ? idx : firstCriticalIdx;
                prevCriticalIdx = idx;
            }
            prev = curr;
            curr = curr.next;
            idx++;
        }
        if(prevCriticalIdx == firstCriticalIdx) {
            return new int[]{-1, -1};
        } else {
            return new int[]{min, prevCriticalIdx - firstCriticalIdx};
        }
    }
}

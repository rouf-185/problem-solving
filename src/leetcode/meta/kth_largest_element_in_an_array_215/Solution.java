package leetcode.meta.kth_largest_element_in_an_array_215;
import java.util.*;
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums) {
            pq.add(n);
            if(pq.size() > k) { // most import lessson here is we shouldn't remove item before inserting k + 1 th item because k+1th could be smaller than top item
                pq.poll();
            }
            
        }
        return pq.poll();
    }
}

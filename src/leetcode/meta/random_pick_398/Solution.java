package leetcode.meta.random_pick_398;
import java.util.*;
public class Solution {
    private Map<Integer, Queue<Integer>> map;
    public Solution(int[] nums) {
        map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new LinkedList<>());
            }
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        int idx = map.get(target).poll();
        map.get(target).add(idx);
        return idx;
    }
}

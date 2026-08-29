package leetcode.daily_challenge.august_26.make_lexicographically_smallest_array_by_swapping_elements_2948;

public class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        List<Deque<Integer>> groups = new ArrayList<>();
        Map<Integer, Integer> groupIdx = new HashMap<>();
        groups.add(new LinkedList<>());
        groups.get(0).offer(sorted[0]);
        groupIdx.put(sorted[0], groups.size() - 1);
        for(int i = 1; i < nums.length; i++) {
            int currentLastItem = groups.get(groups.size() - 1).peekLast();
            int currentItem = sorted[i];
            if(Math.abs(currentLastItem - currentItem) > limit) {
                groups.add(new LinkedList<>());
            }
            groups.get(groups.size() - 1).offer(currentItem);
            groupIdx.put(currentItem, groups.size() - 1);
        }
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            ans[i] = groups.get(groupIdx.get(nums[i])).pollFirst();
        }
        return ans;
    }
} 

package leetcode.meta.top_k_frequent_elements_347;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for(int key : count.keySet()) {
            
            pq.offer(new int[]{key, count.get(key)});
            if(pq.size() > k) {
                int[] x = pq.poll();
                
            }
        } 
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            int[] x =  pq.poll();
            
            ans[i] = x[0];
        }
        return ans;
    }
}

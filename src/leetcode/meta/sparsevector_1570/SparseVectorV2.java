package leetcode.meta.sparsevector_1570;

import java.import.*;

public class SparseVector {
    private Map<Integer, Integer> map;
    SparseVector(int[] nums) {
        map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        Map<Integer, Integer> small = this.map.size() >= vec.map.size() ? vec.map : this.map;
        Map<Integer, Integer> large = this.map.size() < vec.map.size() ? vec.map : this.map;
        int sum = 0;
        for(int key : small.keySet()) {
            if(large.containsKey(key)) {
                sum += small.get(key) * large.get(key);
            }
        }
        return sum;
    }
}

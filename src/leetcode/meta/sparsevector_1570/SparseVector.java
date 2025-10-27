package leetcode.meta.sparsevector_1570;

public class SparseVector {
    private int[] nums;
    SparseVector(int[] nums) {
        this.nums = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        for(int i = 0; i < this.nums.length; i++) {
            sum += this.nums[i] * vec.nums[i];
        }
        return sum;
    }
}

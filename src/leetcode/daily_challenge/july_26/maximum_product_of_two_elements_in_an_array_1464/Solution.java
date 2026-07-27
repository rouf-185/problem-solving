package daily_challenge.july_26.maximum_product_of_two_elements_in_an_array_1464;

public class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = 0; 
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int prod = (nums[i] - 1)*(nums[j] - 1);
                maxProduct = Math.max(prod, maxProduct);
            }
        }
        return maxProduct;
    }
}

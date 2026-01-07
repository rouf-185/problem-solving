package leetcode.daily_challenge.january_26.maximum_product_of_splitted_binary_tree_07;

public class Solution {
    private long total;
    private long ans;
    private final int MOD = 1000000007;
    private void performSum(TreeNode node) {
        if(node == null) {
            return;
        }
        total += node.val;
        performSum(node.left);
        performSum(node.right);
    }
    private long getSubtreeSum(TreeNode node) {
        if(node == null) {
            return 0;
        }
        long leftSum = getSubtreeSum(node.left);
        long rightSum = getSubtreeSum(node.right);
        long sum =  node.val + leftSum + rightSum;
        ans = Math.max((long)(total - sum) * sum, ans);  
        return sum; 
    }
    public int maxProduct(TreeNode root) {
        total = 0;
        ans = Long.MIN_VALUE;
        performSum(root);
        getSubtreeSum(root);
        return (int) (ans % MOD);
    }
}

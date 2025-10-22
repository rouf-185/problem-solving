package leetcode.meta.sum_root_to_leaf_numbers_129;

public class Solution {
    private int ans;
    private void traverse(TreeNode node, int sum) {
        if(node == null) {
            return;
        } 
        sum = sum * 10 + node.val;
        if(node.left == null && node.right == null) {
            ans += sum;
        } else {
            traverse(node.left, sum);
            traverse(node.right, sum);
        }
        sum /= 10;
    }
    public int sumNumbers(TreeNode root) {
        ans = 0;
        traverse(root, 0);
        return ans;
    }
}

package leetcode.meta.closest_binary_search_tree_value_270;

public class Solution {
    private int ans;
    private void traverse(TreeNode node, double target) {
        if(node == null) {
            return;
        } 
        double delta = Math.abs(target - node.val);
        double ansDelta = Math.abs(ans - target);
        ans = (ansDelta == delta) ? Math.min(ans, node.val) : (ansDelta < delta ? ans : node.val);
        if(target < node.val) {
            traverse(node.left, target);
        } else {
            traverse(node.right, target);
        }
    }
    public int closestValue(TreeNode root, double target) {
        ans = root.val;
        traverse(root, target);
        return ans;
    }
}

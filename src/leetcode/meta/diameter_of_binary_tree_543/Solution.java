package leetcode.meta.diameter)=_of_binary_tree_543;


public TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    private int maxLen;
    private int getLongestPath(TreeNode node) {
        if(node == null) {
            return -1; 
            // when left and right are null both return 0 
            //and if we calculate total path left + right + 1 which should be 0
            // that is why we set -1. L(-1) + R(-1) + 2 = 0
        }
        int leftPathLen = getLongestPath(node.left);
        int rightPathLen = getLongestPath(node.right);
        int total  = Math.max(leftPathLen, rightPathLen) + 1;
        maxLen = Math.max(maxLen, leftPathLen + rightPathLen + 2);
        return total;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        this.maxLen = 0;
        getLongestPath(root);
        return maxLen;
    }
}

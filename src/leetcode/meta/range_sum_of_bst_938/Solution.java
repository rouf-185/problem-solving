package leetcode.meta.range_sum_of_bst_938;


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
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }
        if(root.val >=  low && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else {
            return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
    }
}

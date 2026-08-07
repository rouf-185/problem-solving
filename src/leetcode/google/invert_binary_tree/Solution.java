package leetcode/google/invert_binary_tree;

public class class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        TreeNode leftTree = invertTree(root.left);
        TreeNode rightTree = invertTree(root.right);
        root.left = rightTree;
        root.right = leftTree;
        return root;
    }
}

package leetcode.meta.check_completeness_of_a_binary_tree_958;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Solution {
    private int n;
    private void count(TreeNode node) {
        if(node == null) {
            return;
        }
        count(node.left);
        this.n++;
        count(node.right);
    }
    private boolean check(TreeNode node, int idx) {
        if(node == null) {
            return true;
        }
        if(idx >= this.n) {
            return false;
        }
        return check(node.left, 2 * idx + 1) && check(node.right, 2 * idx + 2);
    }
    public boolean isCompleteTree(TreeNode root) {
        count(root);
        return check(root, 0); 
    }
}

package leetcode.meta.lowest_common_ancestor_of_binary_tree_236;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    TreeNode lca;
    // write simple dfs
    boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) {
            return false;
        } 
        //check current node is equal to either
        boolean mid = node == p || node == q;
        boolean left = dfs(node.left, p, q);
        boolean right = dfs(node.right, p, q);
        int midVal = mid ? 1 : 0;
        int leftVal = left ? 1 : 0;
        int rightVal = right ? 1: 0;
        int sum = leftVal + midVal + rightVal;
        if(sum >= 2 && lca == null) {
            lca = node;
        } 
        return sum >= 1;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return lca;
    }
}

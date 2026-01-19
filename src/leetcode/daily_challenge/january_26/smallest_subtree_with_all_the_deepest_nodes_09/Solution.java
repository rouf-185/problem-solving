package leetcode.daily_challenge.january_26.smallest_subtree_with_all_the_deepest_nodes_09;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair {
    public TreeNode node;
    public int depth;
    public Pair(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
} 
public class Solution {
    private Pair calculate(TreeNode node, int depth) {
        if(node == null) {
            return new Pair(null, depth);
        }
        Pair leftPair = calculate(node.left, depth + 1);
        Pair rightPair = calculate(node.right, depth + 1);
        if(leftPair.depth == rightPair.depth) {
            return new Pair(node, leftPair.depth); // rightPair.depth should work as well
        } else if(leftPair.depth > rightPair.depth) {
            return leftPair;
        } else {
            return rightPair;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Pair pair = calculate(root, 0);
        return pair.node;
    }
}

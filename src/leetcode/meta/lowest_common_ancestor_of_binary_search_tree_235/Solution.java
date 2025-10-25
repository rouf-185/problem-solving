package leetcode.meta.lowest_common_ancestor_of_binary_search_tree_235;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 
public class Solution {
    private void savePath(TreeNode node, Queue<TreeNode> path, TreeNode target) {
        if(node == null) {
            return;
        }
        path.offer(node);
        if(node.val == target.val) {
            return;
        } 
        if(node.val > target.val) {
            savePath(node.left, path, target);
        } else {
            savePath(node.right, path, target);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> path1 = new LinkedList<>();
        Queue<TreeNode> path2 = new LinkedList<>();
        savePath(root, path1, p);
        savePath(root, path2, q);
        TreeNode ans = null;
        while(path1.peek() == path2.peek()) {
            ans = path1.peek();
            path1.poll();
            path2.poll();
        }
        return ans;
    }
}

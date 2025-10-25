package leetcode.meta.lowest_common_ancestor_of_binary_tree_236;

import java.util.*;

public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
public class Solution {
    // write simple dfs
    void dfs(TreeNode node, Map<TreeNode, TreeNode> map) {
        if(node == null) {
            return;
        } 
        if(node.left != null) {
            map.put(node.left, node);
            dfs(node.left, map);
        }
        if(node.right != null) {
            map.put(node.right, node);
            dfs(node.right, map);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        dfs(root, parent);
        Set<TreeNode> set = new HashSet<>();
        TreeNode itr = p;
        while(itr != null) {
            set.add(itr);
            itr = parent.get(itr);
        }
        itr = q;
        TreeNode ans = null;
        while(itr != null) {
            if(set.contains(itr)) {
                ans = itr;
                break;
            }
            itr = parent.get(itr);
        }
        return ans;
    }
}

package leetcode.meta.boundary_of_binary_tree_545;

import java.util.*;
class TreeNode {
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

class Solution {
    private List<Integer> leftNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        TreeNode itr = root.left;
        while(itr != null && (itr.left != null || itr.right != null)) {
            list.add(itr.val);
            itr = itr.left == null ? itr.right : itr.left;
        }
        return list;
    }
    
    private List<Integer> rightNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        TreeNode itr = root.right;
        while(itr != null && (itr.left != null || itr.right != null)) {
            list.add(itr.val);
            itr = itr.right == null ? itr.left : itr.right;
        }
        Collections.reverse(list);
        return list;
    }

    private void allLeaves(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }
        if(node.left == null && node.right == null) {
            list.add(node.val);
        }
        allLeaves(node.left, list);
        allLeaves(node.right, list);
    }


    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        results.add(root.val);
        if(root.left ==null && root.right == null) {
            return results;
        }
        results.addAll(leftNodes(root));
        List<Integer> leaves = new ArrayList<>();
        allLeaves(root, leaves);
        results.addAll(leaves);
        results.addAll(rightNodes(root));
        return results;
    }
}

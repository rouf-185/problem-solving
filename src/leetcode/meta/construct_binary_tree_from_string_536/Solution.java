package leetcode.meta.construct_binary_tree_from_string_536;

import java.util.*;


class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Pair {
    public int idx;
    public TreeNode node;
    public Pair(TreeNode node, int idx) {
        this.idx = idx;
        this.node = node;
    }
}
class Solution {
    private int[] getNumber(String str, int idx) {
        boolean isNegative = false;
        if(str.charAt(idx) == '-') {
            isNegative = true;
            idx++;
        }
        int num = 0;
        while(idx < str.length() && Character.isDigit(str.charAt(idx))) {
            // System.out.println(str.charAt(idx));
            num = (num * 10) + (int)(str.charAt(idx) - '0');
            idx++;
        }
        return new int[]{isNegative ? (-1) * num : num, idx};
    }
    private Pair constructSubtree(String str, int idx) {
        if(idx == str.length()) {
            return null;
        }
        int[] numAndIdx = getNumber(str, idx);
        idx = numAndIdx[1];
        int num = numAndIdx[0];
        TreeNode currentRoot = new TreeNode(num);
        
        if(idx < str.length() && str.charAt(idx) == '(') { 
            // it does imply the node has left subtree
            idx++;
            Pair leftSubTreeInfo = constructSubtree(str, idx);
            currentRoot.left = leftSubTreeInfo.node;
            idx = leftSubTreeInfo.idx;
        }

        if(currentRoot.left != null && idx < str.length() && str.charAt(idx) == '(') { 
            // this means it has right subtree too
            idx++;
            Pair rightSubTreeInfo = constructSubtree(str, idx);
            currentRoot.right = rightSubTreeInfo.node;
            idx = rightSubTreeInfo.idx;
        }

        return new Pair(currentRoot, idx + 1);
    }
    public TreeNode str2tree(String s) {
        Pair rootInfo = constructSubtree(s, 0);
        if(rootInfo == null) {
            return null;
        }
        return rootInfo.node;
    }
}

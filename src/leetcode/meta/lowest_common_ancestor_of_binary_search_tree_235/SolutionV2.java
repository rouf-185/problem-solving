package leetcode.meta.lowest_common_ancestor_of_binary_search_tree_235;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode itr = root;
        boolean leftCond = (itr.val > p.val && itr.val > q.val);
        boolean rightCond = (itr.val < p.val && itr.val < q.val);
        while(leftCond || rightCond) {
            if(rightCond) {
                itr = itr.right;
            } else {
                itr = itr.left;
            }
            leftCond = (itr.val > p.val && itr.val > q.val);
            rightCond = (itr.val < p.val && itr.val < q.val);
        }
        return itr;
    }
}

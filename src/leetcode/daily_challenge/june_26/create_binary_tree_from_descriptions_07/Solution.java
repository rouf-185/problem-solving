package leetcode.daily_challenge.june_26.create_binary_tree_from_descriptions_07;

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

public class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> isNotRoot = new HashSet<>();
        for(int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            boolean isLeft = description[2] == 1;
            if(!map.containsKey(parent)) {
                TreeNode parentNode = new TreeNode(parent);
                map.put(parent, parentNode);
            }
            if(!map.containsKey(child)) {
                TreeNode childNode = new TreeNode(child);
                map.put(child, childNode);
            }
            if(isLeft) {
                map.get(parent).left = map.get(child);
            } else {
                map.get(parent).right = map.get(child);
            }
            isNotRoot.add(child);
        }
        TreeNode rootNode = null;
        for(Integer key : map.keySet()) {
            if(!isNotRoot.contains(key)) {
                rootNode = map.get(key);
                break;
            }
        }
        return rootNode;
    }
}

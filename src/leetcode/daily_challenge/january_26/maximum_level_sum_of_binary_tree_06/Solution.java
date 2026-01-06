package leetcode.daily_challenge.january_26.maximum_level_sum_of_binary_tree_06;

public class Solution {
    public int maxLevelSum(TreeNode root) {
        int maxLevel = -1;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 1;
        while(!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            int levelSum = 0;
            for(int i = 0; i < currentLevelSize; i++) {
                TreeNode top = queue.poll();
                levelSum += top.val;
                if(top.left != null) {
                    queue.offer(top.left);
                }
                if(top.right != null) {
                    queue.offer(top.right);
                }
            }
            if(levelSum > maxSum) {
                maxLevel = currentLevel;
                maxSum = levelSum;
            }
            currentLevel++;
        }
        return maxLevel;
    }
}

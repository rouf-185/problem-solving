package leetcode.meta.binary_tree_vertical_order_traversal_314;

public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        TreeMap<Integer, List<Integer>> columnMap = new TreeMap<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        map.put(root, 0);
        while(!queue.isEmpty()) {
            int qSize = queue.size();
            for(int i = 0; i < qSize; i++) {
                TreeNode top = queue.poll();
                int columnIdx = map.get(top);
                if(!columnMap.containsKey(columnIdx)) {
                    columnMap.put(columnIdx, new ArrayList<>());
                }
                columnMap.get(columnIdx).add(top.val);
                if(top.left != null) {
                    map.put(top.left, columnIdx - 1);
                    queue.add(top.left);
                }
                if(top.right != null) {
                    map.put(top.right, columnIdx + 1);
                    queue.add(top.right);
                }
            }
        }
        for(int key : columnMap.keySet()) {
            ans.add(columnMap.get(key));
        }
        return ans;
    }
}

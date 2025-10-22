package leetcode.meta.clone_graph_133;

import java.util.*;
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Solution {
    private Node dfs(Node node, Map<Integer, Node> map) {
        if(map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node clonedNode = new Node(node.val);
        map.put(node.val, clonedNode);
        for(Node nei : node.neighbors) {
            Node childNode = dfs(nei, map);
            clonedNode.neighbors.add(childNode);
            // childNode.neighbors.add(clonedNode);
        }
        return clonedNode;
    } 
    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        if(node != null) {
            dfs(node, map);
        }
        return node != null ? map.get(node.val) : null;
    }
}

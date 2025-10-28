package leetcode.meta.lowest_common_ancestor_of_a_binary_tree_III;

import java.util.HashSet;
import java.util.Set;
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};


public class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> visited = new HashSet<>();
        Node itrP = p;
        while(itrP != null) {
            visited.add(itrP);
            itrP = itrP.parent;
        }
        Node itrQ = q;
        while(!visited.contains(itrQ)) itrQ = itrQ.parent;
        return itrQ;
    }
}
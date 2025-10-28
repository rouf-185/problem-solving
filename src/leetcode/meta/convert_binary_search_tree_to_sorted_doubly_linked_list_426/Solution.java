package leetcode.meta.convert_binary_search_tree_to_sorted_doubly_linked_list_426;

public class Solution {
    private Node[] inorder(Node node) {
        if(node == null) {
            return new Node[]{};
        }
        Node[] leftList = inorder(node.left);
        Node newNode = new Node(node.val);
        Node[] rightList = inorder(node.right);

        Node[] entireList = {newNode, newNode};
        
        if(leftList.length == 2) {
            leftList[1].right = newNode;
            newNode.left = leftList[1];
            entireList[0] = leftList[0];
        }
        if(rightList.length == 2) {
            newNode.right = rightList[0];
            rightList[0].left = newNode;
            entireList[1] = rightList[1];
        }

        return entireList;
    }
    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }
        Node[] twoEnds = inorder(root);
        Node leftEnd = twoEnds[0];
        Node rightEnd = twoEnds[1];
        leftEnd.left = rightEnd;
        rightEnd.right = leftEnd;
        Node head = leftEnd;
        return head;
    }
}

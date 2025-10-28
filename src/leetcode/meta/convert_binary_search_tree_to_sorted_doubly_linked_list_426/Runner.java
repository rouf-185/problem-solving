package leetcode.meta.convert_binary_search_tree_to_sorted_doubly_linked_list_426;

public class Runner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        Node head = sol.treeToDoublyList(root);
        Node curr = head;
        for(int i = 0; i < 5; i++) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }
}

package leetcode.meta.insertion_into_a_sorted_circular_linked_list_708;



class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};


pubic class Solution {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if(head == null) {
            head = newNode;
            newNode.next = newNode;
            return head;
        }
        Node prev = head;
        Node current = head.next;
        boolean isPlaced = false;
        while(current != head) {
            if(prev.val <= insertVal && insertVal <= current.val) {
                break;
            } else if(prev.val > current.val && (insertVal > prev.val || insertVal < current.val)) {
                break;
            }
            prev = prev.next;
            current = current.next;
        }
        newNode.next = current;
        prev.next = newNode;
        return head;
    }
}

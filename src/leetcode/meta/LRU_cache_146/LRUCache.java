package leetcode.meta.LRU_cache_146;
import java.util.*;
public class LRUCache {
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        this.map = new HashMap<>();
    }
    
    private void removeFromList(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        if(prevNode == null) {
            // removing first item
            this.head = nextNode;
            if(nextNode != null) this.head.prev = null;
        } 
        if(nextNode == null) {
            //removing last item
            this.tail = prevNode;
            if(prevNode != null) this.tail.next = null;
        }
        if(prevNode != null && nextNode != null) {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        node.prev = null;
        node.next = null;
    }

    private void addLast(Node newNode) {
        if(tail == null) {
            this.tail = newNode;
            this.head = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public int get(int key) {
       if(map.containsKey(key)) {
            int val = map.get(key).val;
            removeFromList(map.get(key));
            Node node = new Node(key, val);
            addLast(node);
            map.put(key, node);
            return val;
       } else {
            return -1;
       }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            removeFromList(map.get(key));
        } else {
            if(map.size() == this.capacity) {
                int headKey = this.head.key;
                removeFromList(map.get(headKey));
                map.remove(headKey);
            }
        }
        Node node = new Node(key, value);
        addLast(node);
        map.put(key, node);
    }
}

class Node {
    public int val;
    public int key;
    public Node next;
    public Node prev;
    public Node(int val, int key) {
        this.val = val;
        this.key = key;
        this.next = null;
        this.prev = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
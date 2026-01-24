package leetcode.daily_challenge.january_26.minimum_pair_removal_to_sort_array_II;

import java.util.*;


class Node {
    public long value;
    public int leftIdx;
    public Node prev;
    public Node next;
    public Node(long value, int idx) {
        this.value = value;
        this.leftIdx = idx;
        this.prev = null;
        this.next = null;
    }
}

class Pair implements Comparable<Pair> {
    public Node first;
    public Node second;
    public long sum;
    public Pair(Node first, Node second, long sum) {
        this.first = first;
        this.second = second;
        this.sum = sum;
    }
    @Override
    public int compareTo(Pair other) {
        if(this.sum == other.sum) {
            return this.first.leftIdx - other.first.leftIdx;
        }
        return this.sum <= other.sum ? -1 : 1;
    }
}

public class Solution {
    public int minimumPairRemoval(int[] nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int opCount = 0;
        int decreasingCount = 0;
        boolean[] merged = new boolean[nums.length];

        Node head = new Node(nums[0], 0);
        Node current = head;
        for(int i = 1; i < nums.length; i++) {
            Node newNode = new Node(nums[i], i);
            current.next = newNode;
            newNode.prev = current;
            pq.offer(new Pair(current, newNode, current.value + newNode.value));
            if(current.value > newNode.value) {
                decreasingCount++;
            }
            current = current.next;
        }

        while(decreasingCount > 0) {
            if(pq.isEmpty()) {
                break;
            }
            Pair top = pq.poll();
            Node first = top.first;
            Node second = top.second;
            long sum = top.sum;
            if(merged[first.leftIdx] || merged[second.leftIdx] || (sum != first.value + second.value)) {
                continue;
            }
        
            Node prevNode = first.prev;
            Node nextNode = second.next;
            first.next = nextNode;
            if(first.value > second.value) {
                decreasingCount--;
            }
            if(nextNode != null) {
                nextNode.prev = first;
            }

            if(prevNode!= null) {
                if(prevNode.value > first.value && prevNode.value <= sum) {
                    decreasingCount--;
                } else if(prevNode.value <= first.value && prevNode.value > sum) {
                    decreasingCount++;
                }
                pq.offer(new Pair(prevNode, first, prevNode.value + sum));
            }

            if(nextNode != null) {
                if(nextNode.value >= second.value && nextNode.value < sum) {
                    decreasingCount++;
                } else if(nextNode.value < second.value && nextNode.value >= sum) {
                    decreasingCount--;
                }
                pq.offer(new Pair(first, nextNode, nextNode.value + sum));
            }

            first.value = sum;
            merged[second.leftIdx] = true;
            opCount++;
        }
        return opCount;
    }
}

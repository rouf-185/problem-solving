package leetcode.meta.find_k_closest_elements_658;

import java.util.*;
public class Solution {
    private int binarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == x) {
                return mid;
            } else if(arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if(left == arr.length) {
            return arr.length - 1;
        }
        if(right < 0) {
            return 0;
        }
        if(Math.abs(arr[left] - x) < Math.abs(arr[right] - x)) {
            return left;
        } else {
            return right;
        }
        
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(k == arr.length) {
            List<Integer> list = new ArrayList<>(arr.length);
            for (int v : arr) list.add(v);
            return list;
        }
        int pivot = binarySearch(arr, x);
        System.out.println("pivot: " + pivot);
        int left = pivot;
        int right = pivot;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(arr[pivot]);
        while(deque.size() < k) {
            if((right + 1) >= arr.length) {
                deque.offerFirst(arr[--left]);
            } else if((left - 1) < 0) {
               deque.offerLast(arr[++right]);
            } else {
                if(Math.abs(arr[left - 1] - x) <= Math.abs(arr[right + 1] - x)) {
                    deque.offerFirst(arr[--left]);
                } else {
                    deque.offerLast(arr[++right]);
                }
            }
        }
        return new ArrayList<>(deque);
    }
}

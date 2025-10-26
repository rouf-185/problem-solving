package leetcode.meta.kth_missing_positive_number_1539;
import java.util.*;
public class Solution {
    public int findKthPositive(int[] arr, int k) {
        int x = 1;
        int idx = 0;
        int notFound = 0;
        while(notFound < k) {
            if(idx < arr.length && arr[idx] == x) {
                idx++;
            } else {
                notFound++;
            }
            x++;
        }
        return x - 1;
    }
}

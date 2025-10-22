package leetcode.meta.merge_sorted_array_21;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        for(int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }
        int k = 0;
        int i = 0;
        int j = 0;
        while(i < m || j < n) {
            if(i >= m) {
                nums1[k++] = nums2[j++];
            } else if(j >= n) {
                nums1[k++] = nums1Copy[i++];
            } else {
                if(nums2[j] < nums1Copy[i]) {
                    nums1[k++] = nums2[j++];
                } else {
                    nums1[k++] = nums1Copy[i++];
                }
            }
        }
    }
}

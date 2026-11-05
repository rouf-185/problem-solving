package leetcode.daily_challenge.november_26.find_the_distance_value_between_two_arrays_1385;

public class Solution {
    private int find(int[] arr2, int target, boolean lessOrEqual) {
        int left = 0;
        int right = arr2.length - 1;
        int ans = -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(lessOrEqual) {
                if(arr2[mid] <= target) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if(arr2[mid] >= target) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return ans != -1 ? arr2[ans] : -1001;
    }
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        Arrays.sort(arr2);
        for(int i = 0; i < arr1.length; i++) {
            int lessOrEqual = find(arr2, arr1[i], true);
            int greaterOrEqual = find(arr2, arr1[i], false);
            if((lessOrEqual == -1001 
            || Math.abs(lessOrEqual - arr1[i]) > d) 
            && (greaterOrEqual == -1001
            || Math.abs(greaterOrEqual - arr1[i]) > d)) {
                count++;
            }
        }
        return count;
    }
}

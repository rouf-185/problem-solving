package leetcode.daily_challenge.january_26.maximum_side_length_of_a_square_with_sum_less_than_or_equal_to_threshold_19;

public class Solution {
    private boolean lookupValidSquare(int[][] mat, int[][] p, int threshold, int size) {
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 1; i <= m - size + 1; i++) {
            for(int j = 1; j <= n - size + 1; j++) {
                int x1 = i;
                int y1 = j;
                int x2 = i + size - 1;
                int y2 = j + size - 1;
                int sum = p[x2][y2] - p[x2][y1 - 1] - p[x1 - 1][y2] + p[x1 - 1][y1 - 1];
                if(sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefixSum = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int left = 1;
        int right = Math.min(m, n);
        int ans = 0;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(lookupValidSquare(mat, prefixSum, threshold, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}

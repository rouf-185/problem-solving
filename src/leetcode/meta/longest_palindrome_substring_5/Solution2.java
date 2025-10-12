
package leetcode.meta.longest_palindrome_substring_5;

public class Solution2 { 
    private int[] expand(int start, int end, String s) {
        int i = start;
        int j = end;
        while(i - 1 >= 0 
            && j + 1 < s.length() 
            && s.charAt(i - 1) == s.charAt(j + 1)) {
            i--;
            j++;
        }
        return new int[]{i, j};
    }
    public String longestPalindrome(String s) {
        int[] ans = new int[]{0, 0};
        int n = s.length();
        for(int i = 0; i < n; i++) {
            int[] range = expand(i, i, s);
            if(range[1] - range[0] > ans[1]  - ans[0]) {
                ans[0] = range[0];
                ans[1] = range[1];
            }
            if(i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                range = expand(i, i + 1, s);
                if(range[1] - range[0] > ans[1]  - ans[0]) {
                    ans[0] = range[0];
                    ans[1] = range[1];
                }
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }
}

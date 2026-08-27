package leetcode.daily_challenge.august_26.shortest_and_lexicographically_smallest_beautiful_string_2904;

public class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int ones = 0;
        String ansStr = "";
        boolean found = false;
        while(right < s.length()) {
            ones += s.charAt(right) == '1' ? 1 : 0;
            while(ones > k || (ones == k && s.charAt(left) == '0')) {
                if(s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }
            if(ones == k) { 
                int len = (right - left + 1);
                String tempStr = s.substring(left, right + 1);
                if(len < ans) {
                    ans = len;
                    ansStr = tempStr;
                } else if(len ==  ans && ansStr.compareTo(tempStr) > 0) {
                    ansStr = tempStr;
                }
            }
            right++;
        }
        
        return ansStr ;
    }
}

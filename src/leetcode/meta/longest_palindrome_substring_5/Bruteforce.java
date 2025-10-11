package leetcode.meta.longest_palindrome_substring_5;

public class Bruteforce {
    private boolean isPalindrome(int start, int end, String s) {
        boolean isPal = true;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                isPal = false;
                break;
            }
            start++;
            end--;
        }
        return isPal;
    }
    public String longestPalindrome(String s) {
        int maxLen = 0;
        String ans = "";
        for(int i = 0; i < s.length(); i++) {
            for(int j = s.length() - 1; j >= i; j--) {
                if(isPalindrome(i, j, s) && maxLen < j - i + 1) {
                    ans = s.substring(i, j + 1);
                    maxLen = j - i + 1;
                }
            }
        }
        return ans;
    }
}

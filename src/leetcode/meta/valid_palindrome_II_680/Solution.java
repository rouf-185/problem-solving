package leetcode.meta.valid_palindrome_II_680;

import java.util.*;

public class Solution {
    private boolean isPalindrome(String s, int i, int j) {
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                if(isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1)) {
                    return true;
                } else {
                    return false;
                }
            }
            start++;
            end--;
        }    
        return true;
    }
}

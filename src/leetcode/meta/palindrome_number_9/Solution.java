package leetcode.meta.palindrome_number_9;

public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int newX = 0;
        int temp = x;
        while(temp > 0) {
            newX *= 10;
            newX += (temp % 10);
            temp /= 10;
        }
        return newX == x;
    }
}

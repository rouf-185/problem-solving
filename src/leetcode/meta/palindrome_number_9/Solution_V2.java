
package leetcode.meta.palindrome_number_9;

public class Solution_V2 {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)) { 
            // this is crucial. if x is less than 0 or x > 0 and remainder is 0 because x == 0 is palindrome
            return false;
        }
        int newX = 0;
        int tempX = x;
        while(tempX > newX) {
            newX = (newX * 10) + (tempX % 10);
            tempX /= 10;
        }
        return newX == tempX || newX / 10 == tempX;
    }
}

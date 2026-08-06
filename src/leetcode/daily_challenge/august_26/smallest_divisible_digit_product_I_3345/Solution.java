package leetcode.daily_challenge.august_26.smallest_divisible_digit_product_I_3345;

public class Solution {
    public int smallestNumber(int n, int t) {
        for(int i = n ; i <= 1000; i++) {
            int x = i;
            int digitProd = 1;
            while(x > 0) {
                digitProd *= (x % 10);
                x = x / 10;
            }
            if(digitProd % t == 0) {
                return i;
            }
        }
        return -1;
    }
}

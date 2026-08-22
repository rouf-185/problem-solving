package leetcode.daily_challenge.august_26.check_divisibility_by_digit_sum_and_product_3622; 

public class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        int x = n;
        while(x > 0) {
            sum += (x % 10);
            product *= (x % 10);
            x /= 10;
        }
        return n % (sum + product) == 0;
    }
}

package leetcode.daily_challenge.january_26.four_divisors_04;

public class Solution {
    private boolean[] notPrime;
    private final int MAX_NUM = 100000;
    public Solution() {
        notPrime = new boolean[MAX_NUM + 1];
        notPrime[1] = true;
        for(int i = 2; i * i <= MAX_NUM; i++) {
            if(notPrime[i]) continue;
            for(int j = i * i; j <= MAX_NUM; j+=i) {
                notPrime[j] = true;
            }
        }
    }
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            int p = (int)Math.round(Math.cbrt(n));
            if(!notPrime[p] && (long) p * p * p == n) {
                sum += 1 + p + p * p + n;
                continue;
            }
            for(int i = 2; i * i <= n; i++) {
                if(notPrime[i] || n % i != 0) continue;
                if(!notPrime[n/i] && i != (n/i)) {
                    sum += 1 + i + (n/i) + n;
                    break;
                }
            }
        }
        return sum;
    }
}

package leetcode.daily_challenge.january_26.four_divisors_04;

public class Solution {
    private boolean[] notPrime;
    public Solution() {
        notPrime = new boolean[100000 + 1];
        notPrime[1] = true;
        for(int i = 2; i * i <= 100000; i++) {
            if(notPrime[i] == false) {
                for(int j  = i * i; j <= 100000; j+=i) {
                    notPrime[j] = true;
                }
            }
        }
    }
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for(int n : nums) {
            int p = (int) Math.round(Math.cbrt(n));
            if ((long) p * p * p == n && !notPrime[p]) {
                ans += (1 + p + p * p + n);
                continue;
            }
            for(int j = 2; j * j <= n; j++) {
                if(notPrime[j]) continue;
                if(n % j != 0) continue;
                int r = j;
                int s = n / r;
                if(r != s && !notPrime[r] && !notPrime[s]) {
                    ans += (1 + r + s + n);
                }
                break;
            }
        }
        return ans;
    }
}

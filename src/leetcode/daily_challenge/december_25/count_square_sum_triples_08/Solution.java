package leetcode.daily_challenge_december_25.count_square_sum_triples_08;

public class Solution {
    public int countTriples(int n) {
        int ans = 0;
        for(int i = 1; i <= n-2; i++) {
            for(int j = i + 1; j <= n - 1; j++) {
                double c = Math.sqrt(i * i + j * j);
                int int_c = (int)c;
                if(c - int_c > 0) continue;
                if(c <= n) ans += 2;
            }
        }
        return ans;
    }
}

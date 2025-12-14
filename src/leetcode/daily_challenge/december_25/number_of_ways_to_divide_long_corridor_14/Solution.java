package leetcode.daily_challenge_december_25.number_of_ways_to_divide_long_corridor_14;

import java.util.*;

public class Solution {
    private final int  MOD = 1000000007;
    public int numberOfWays(String corridor) {
        List<Integer> seatIdx = new ArrayList<>();
        for(int i = 0; i < corridor.length(); i++) {
            if(corridor.charAt(i) == 'S') {
                seatIdx.add(i);
            }
        }
        if(seatIdx.size() % 2 == 1 || seatIdx.size() == 0) {
            return 0;
        }
        long ans = 1;
        for(int i = 2; i < seatIdx.size(); i += 2) {
            ans = (ans * (long)(seatIdx.get(i) - seatIdx.get(i - 1))) % MOD;
        }
        return (int) ans;
    }
}

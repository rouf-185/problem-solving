package leetcode.daily_challenge.august_26.kth_smallest_amount_with_single_denomination_combination_3116;

public class Solution {
    private Map<Integer, List<Long>> lcms;
    private int[] coins;
    private void setLcms() {
        int len = coins.length;
        int n = 1 << len;
        for(int i = 1; i < n; i++) {
            int x = i;
            int k = 0;
            int bits = 0;
            long lcm = 1;
            // System.out.print("X = " + x + ": ");
            while(x > 0) {
                if(x % 2 == 1) {
                    // System.out.print("1");
                    bits++;
                    long g = gcd(lcm, coins[k]);
                    lcm = ((lcm * coins[k]) / g);
                } else {
                    // System.out.print("0");
                }
                x /= 2;
                k++;
            }
            // System.out.print(" == LCM : " + lcm + "\n");
            if(!lcms.containsKey(bits)) {
                lcms.put(bits, new ArrayList<>());
            }
            lcms.get(bits).add(lcm);
        }
    }
    private long gcd(long a, long b) {
        while(b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    private long count(long x) {
        long total = 0;
        for(int i = 1; i <= coins.length; i++) {
            // System.out.println("i: " + i + " Size: " + lcms.get(i).size());
            for(long lcm : lcms.get(i)) {
                total = (i % 2 == 1) 
                ? (total + (x / lcm)) 
                : (total - (x / lcm));
            }
        }
        return total;
    }

    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);
        this.coins = coins;
        this.lcms = new HashMap<>();
        setLcms();
        long left = k;
        long right = ((long)k * (long)coins[0]) + 1;
        while(left < right) {
            long mid = left + (right - left) / 2;
            if(count(mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

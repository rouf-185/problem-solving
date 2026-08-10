package leetcode.daily_challenge.august_26.stone_game_II_1140;


public class Solution {
    private Integer[][] cache;
    private int[] piles;
    private int getMax(int idx, int M) {
        if(idx >= cache.length || M >= cache.length + 1) {
            return 0;
        }
        if(cache[idx][M] != null) {
            return cache[idx][M];
        } 
        int maxScore = Integer.MIN_VALUE;
        int total = 0;
        for(int x = 1; (x <= (2 * M)) && (idx + x - 1 < piles.length); x++) {
            total += piles[idx + x - 1];
            int newM = Math.max(x, M);
            maxScore = Math.max(maxScore, total - getMax(idx + x, newM));
        }
        cache[idx][M] = maxScore;
        return maxScore;
    }
    public int stoneGameII(int[] piles) {
        cache = new Integer[piles.length][piles.length + 1];
        this.piles = piles;
        int total = 0;
        for(int p : piles) {
            total += p;
        }
        int diff = getMax(0, 1);
        System.out.println("Alice - Bob: " + diff);
        return (total + diff)/2;
    }
}

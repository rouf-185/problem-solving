package leetcode.daily_challenge.august_26.stone_game_IV_1510;


public class Solution {
    private Boolean[][] memo;
    private List<Integer> possibleSquares;
    private List<Integer> getSquareNumbers() {
        int m = 1000;
        List<Integer> squareNumbers = new ArrayList<>();
        for(int i = 1; i <= m; i++) {
            squareNumbers.add(i * i);
        }
        return squareNumbers;
    }
    private boolean isAliceWinner(int x, boolean alicesTurn) {
        if(x == 0) {
            return alicesTurn ? false : true;
        }
        int turn = alicesTurn ? 0 : 1;
        if(this.memo[x][turn] != null) {
            return this.memo[x][turn];
        }
        boolean decision = alicesTurn ? false : true;
        for(int i = 0; i < 1000; i++) {
            int s = this.possibleSquares.get(i);
            if(s > x) break;
            if(alicesTurn) { 
                decision |= isAliceWinner(x - s, false); 
            } else {
                decision &= isAliceWinner(x - s, true); 
            }
        }
        this.memo[x][turn] = decision;
        return decision;
    }
    public boolean winnerSquareGame(int n) {
        this.possibleSquares = getSquareNumbers();
        this.memo = new Boolean[n + 1][2];
        return isAliceWinner(n, true);
    }
}

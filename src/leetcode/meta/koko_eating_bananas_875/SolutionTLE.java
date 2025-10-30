packge leetcode.meta.koko_eating_bananas_875;


public class SolutionTLE {
    private int[] piles;
    private boolean hoursExceed(int k, int maxHour){
        int hours = 0;
        for(int pile : piles) {
            hours += (pile + k - 1)/k; // for ceiling
            if(hours > maxHour) {
                return true;
            }
        }
        return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        this.piles = piles;
        int speed = 1;
        while(true) {
            boolean isExceed = hoursExceed(speed, h);
            if(isExceed) {
                speed++;
                continue;
            }
            break;
        }
        return speed;
    }
}

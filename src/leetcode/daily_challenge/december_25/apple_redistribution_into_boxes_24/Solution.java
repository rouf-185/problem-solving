package leetcode.daily_challenge.december_25.apple_redistribution_into_boxes_24;

import java.util.Arrays;

public class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int total = 0;
        for(int ap : apple) {
            total += ap;
        }
        int count = 0;
        for(int i = capacity.length - 1; i >= 0; i--) {
            total -= capacity[i];
            count++;
            if(total <= 0) {
                break;
            }
        }
        return count;
    }
}

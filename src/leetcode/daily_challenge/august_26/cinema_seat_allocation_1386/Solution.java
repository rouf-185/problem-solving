package leetcode.daily_challenge.august_26.cinema_seat_allocation_1386;

public class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0b00001111;
        int right = 0b11110000;
        int middle = 0b00111100;
        for(int[] res : reservedSeats) {
            if(res[1] == 1 || res[1] == 10) continue;
            if(!map.containsKey(res[0])) {
                map.put(res[0], 0);
            }
            map.put(res[0], (map.get(res[0]) | (1 << (res[1] - 2))));
        }
        int remaining = n - map.size();
        int ans = (remaining * 2);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if((val | left) == left || (val | right) == right || (val | middle) == middle) {
                ans++;
            }
        }
        return ans;
    }
}

package leetcode.daily_challenge.june_26.maximum_number_of_balloons_22;

public class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> balloonMap = new HashMap<>();
        balloonMap.put('b', 0);
        balloonMap.put('a', 0);
        balloonMap.put('l', 0);
        balloonMap.put('o', 0);
        balloonMap.put('n', 0);
        for(char c: text.toCharArray()) {
            if(balloonMap.containsKey(c)) {
                balloonMap.put(c, balloonMap.get(c) + 1);
            }
        }
        balloonMap.put('l', balloonMap.get('l') >> 1);
        balloonMap.put('o', balloonMap.get('o') >> 1);
        int lowestCount = Integer.MAX_VALUE;
        for(char key : balloonMap.keySet()) {
            lowestCount = Math.min(lowestCount, balloonMap.get(key));
        }
        return lowestCount;
    }
}

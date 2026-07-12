package leetcode.daily_challenge.july_26.rank_transform_of_an_array_1331;

public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Integer[] sorted = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++) {
            sorted[i] = arr[i];
        }
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(sorted[i])) {
                continue;
            }
            counter++;
            map.put(sorted[i], counter);
        }
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}

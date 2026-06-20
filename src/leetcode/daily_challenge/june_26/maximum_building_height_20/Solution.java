import leetcode.daily_challenge.june_26.maximum_building_height_20;

public class Solution {
    public int maxBuilding(int num, int[][] restrictions) {
        List<int[]> rest = new ArrayList<>();
        for(int[] r : restrictions) {
            rest.add(new int[]{r[0], r[1]});
        }
        rest.add(new int[]{1, 0});
        Collections.sort(rest, (a, b) -> (a[0] - b[0]));
        if(rest.get(rest.size() - 1)[0] != num) {
            rest.add(new int[]{num , num - 1});
        }
        //from left to right
        for(int i = 1; i < rest.size(); i++) {
            rest.get(i)[1] = Math.min(rest.get(i)[1], rest.get(i - 1)[1] + (rest.get(i)[0] - rest.get(i - 1)[0]));
        }

        for(int i = rest.size() - 2; i >= 0; i--) {
            rest.get(i)[1] = Math.min(rest.get(i)[1], rest.get(i + 1)[1] + (rest.get(i + 1)[0] - rest.get(i)[0]));
        }

        int maxHeight = 0;
        for(int i = 1; i < rest.size(); i++) {
            int pMax = (rest.get(i)[0] - rest.get(i - 1)[0] + rest.get(i)[1] + rest.get(i - 1)[1])/2;
            maxHeight = Math.max(pMax, maxHeight);
        }
        return maxHeight;
    }
}

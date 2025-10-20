package leetcode.meta.interval_list_intersections_986;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0; 
        int j = 0;
        List<int[]> intersectionIntervals = new ArrayList<>();
        while(i < firstList.length && j < secondList.length) {
            int left = Math.max(firstList[i][0], secondList[j][0]);
            int right = Math.min(firstList[i][1], secondList[j][1]);
            if(left <= right) {
                intersectionIntervals.add(new int[]{left, right});
            }
            if(firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        int[][] ans = new int[intersectionIntervals.size()][2];
        for(int k = 0; k < ans.length; k++) {
            ans[k] = intersectionIntervals.get(k);
        }
        return ans;
    }
}

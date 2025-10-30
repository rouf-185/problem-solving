package leetcode.meta.k_closest_points_to_origin_973;

class Pair {
    public int idx;
    public double dist;
    public Pair(int idx, double dist) {
        this.idx = idx;
        this.dist = dist;
    }
}
class Solution {
    private double calculateDist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    private List<List<Pair>> split(List<Pair> closer, double target) {
        List<Pair> close = new ArrayList<>();
        List<Pair> far = new ArrayList<>();
        for(int i = 0; i < closer.size(); i++) {
            if(closer.get(i).dist <= target) {
                close.add(closer.get(i));
            } else {
                far.add(closer.get(i));
            }
        }
        List<List<Pair>> returnItems = new ArrayList<>();
        returnItems.add(close);
        returnItems.add(far);
        return returnItems;
    } 
    public int[][] kClosest(int[][] points, int k) {
        List<Pair> closest = new  ArrayList<>();
        List<Pair> closer = new ArrayList<>();
        double maxDist = 0;
        for(int i = 0; i < points.length; i++) {
            double dist = calculateDist(points[i]);
            maxDist = Math.max(dist, maxDist);
            closer.add(new Pair(i, dist));
        }
        double low = 0;
        double high = maxDist;
        while(closest.size() < k) {
            double mid = low + (high - low) / 2;
            List<List<Pair>> splits = split(closer, mid);
            if(splits.get(0).size() <= (k - closest.size())) {
                closest.addAll(splits.get(0));
                closer = splits.get(1);
                low = mid;
            } else {
                closer = splits.get(0);
                high = mid;
            }
        }
        int[][] ans = new int[closest.size()][2];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = points[closest.get(i).idx];
        }
        return ans;
    }
}

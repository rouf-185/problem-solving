package leetcode.daily_challenge.january_26.minimum_cost_path_with_edge_reversals_27;


import java.util.*;

class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            adj.get(from).add(new int[]{to, weight});
            adj.get(to).add(new int[]{from, 2 * weight});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        dist[0] = 0;
        while(!pq.isEmpty()) {
            int[] item = pq.poll();
            if(visited[item[0]]) {
                continue;
            }
            visited[item[0]] = true;
            if(item[0] == n - 1) {
                return dist[n - 1];
            }
            for(int[] nei : adj.get(item[0])) {
                if(dist[nei[0]] > dist[item[0]] + nei[1]) {
                    dist[nei[0]] = dist[item[0]] + nei[1];
                    pq.offer(new int[]{nei[0], dist[nei[0]]});
                }
            }
        }
        return -1;
    }
}

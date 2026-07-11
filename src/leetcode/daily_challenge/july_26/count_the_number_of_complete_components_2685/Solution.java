package leetcode.daily_challenge.july_26.count_the_number_of_complete_components_2685;

public class Solution {
    private int vCount = 0;
    private int eCount = 0;
    private List<List<Integer>> graph;
    private boolean[] visited;
    private void dfs(int u) {
        visited[u] = true;
        vCount++;
        for(int nei : graph.get(u)) {
            eCount++;
            if(visited[nei]) continue;
            dfs(nei);
        }
    }
    private void constructGraph(int n, int[][] edges) {
        graph = new ArrayList<>();
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        constructGraph(n, edges);
        int cccount = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                continue;
            } else {
                dfs(i);
                if(vCount * (vCount - 1) == eCount) {
                    cccount++;
                }
                vCount = 0;
                eCount = 0;
            }
        }
        return cccount;
    }
}

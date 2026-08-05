package leetcode.daily_challenge.august_26.remove_methods_from_project_3310;


public class Solution {
    private void dfs(List<Set<Integer>> adj, int u, Set<Integer> sus) {
        if(sus.contains(u)) {
            return;
        }
        sus.add(u);
        for(int nei : adj.get(u)) {
            dfs(adj, nei, sus);
        }
    }
    private boolean findSuspicious(List<Set<Integer>> adj, int u, Set<Integer> sus, Set<Integer> visited) {
        if(visited.contains(u)) {
            return false;
        }
        if(sus.contains(u)) {
            return true;
        }
        visited.add(u);
        boolean isFound = false;
        for(int nei : adj.get(u)) {
            isFound |= findSuspicious(adj, nei, sus, visited);
        }
        return isFound;
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Set<Integer> sus = new HashSet<>();
        List<Set<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for(int[] edge : invocations) {
            adj.get(edge[0]).add(edge[1]);
        }
        dfs(adj, k, sus);
        Set<Integer> ans = new HashSet<>();
        for(int i = 0; i < n; i++) {
            ans.add(i);
        }
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < n; i++) {
            if(visited.contains(i) || sus.contains(i)) {
                continue;
            } else {
                if(findSuspicious(adj, i, sus, visited)) {
                    return new ArrayList<>(ans);
                }
            }
        }
        for(int i = 0; i< n; i++) {
            if(sus.contains(i)) ans.remove(i);
        }
        return new ArrayList<>(ans);
    }
}

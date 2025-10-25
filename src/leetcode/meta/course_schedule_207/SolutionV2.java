package leetcode.meta.course_schedule_207;

public class Solution {
    private boolean dfs(List<List<Integer>> adj, boolean[] visited, int x, Set<Integer> instack) {
        if(instack.contains(x)) {
            return true;
        } 
        if(visited[x]) {
            return false;
        }
        visited[x] = true;
        instack.add(x);
        for(int nei : adj.get(x)) {
            if(dfs(adj, visited, nei, instack)) {
                return true;
            }
        }
        instack.remove(x);
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }
        boolean[] visited = new boolean[numCourses];
        Set<Integer> instack = new HashSet<>();
        for(int i = 0; i < numCourses; i++) {
            if(dfs(adj, visited, i, instack)) {
                return false;
            }
        }
        return true;
    }
}

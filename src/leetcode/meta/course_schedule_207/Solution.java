package leetcode.meta.course_schedule_207;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int [] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        int visitedNodes = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int top = queue.poll();
            visitedNodes++;
            for(int nei : adj.get(top)) {
                indegree[nei]--;
                if(indegree[nei] == 0) {
                    queue.add(nei);
                }
            }
        }
        return visitedNodes == numCourses;
    }
}

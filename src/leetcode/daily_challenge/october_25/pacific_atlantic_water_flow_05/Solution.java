package leetcode.daily_challenge.october_25.pacific_atlantic_water_flow_05;

public class Solution {
    public int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void bfs(int[][] heights, int x, int y, boolean[][] visited) {
        if(visited[x][y]) {
            return;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int[] top = queue.poll();
            for(int[] dir : dirs) {
                int newX = top[0] + dir[0];
                int newY = top[1] + dir[1];
                if(newX < 0 
                || newX >= heights.length 
                || newY < 0 
                || newY >= heights[0].length 
                || visited[newX][newY] 
                || heights[top[0]][top[1]] > heights[newX][newY]) {
                    continue;
                }
                
                visited[newX][newY] = true;
                queue.offer(new int[]{newX, newY});
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] visitedPacific = new boolean[heights.length][heights[0].length];
        boolean[][] visitedAtlantic = new boolean[heights.length][heights[0].length];
        //starts from: top, left, bottom, right
        for(int i = 0; i < heights[0].length; i++) {
            // top
            bfs(heights, 0, i, visitedPacific);
            //bottom
            bfs(heights, heights.length - 1, i, visitedAtlantic);
        }

        for(int i = 0; i < heights.length; i++) {
            // left
            bfs(heights, i, 0, visitedPacific);
            //right
            bfs(heights, i, heights[0].length - 1, visitedAtlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < heights.length; i++) {
            for(int j = 0; j < heights[0].length; j++) {
                if(visitedPacific[i][j] == true && visitedAtlantic[i][j] == true) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
}

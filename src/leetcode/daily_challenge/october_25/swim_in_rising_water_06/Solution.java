package leetcode.daily_challenge.october_25.swim_in_rising_water_06;
import java.util.*;

public class Solution {
    public int swimInWater(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] start = new int[]{0, 0};
        int[] end = new int[]{grid.length - 1, grid[0].length - 1};
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int result = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[start[0]][start[1]], start[0], start[1]});
        visited[start[0]][start[1]] = true;
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int val = top[0];
            result = Math.max(val, result);
            int x = top[1];
            int y = top[2];
            if(x == end[0] && y == end[1]) {
                break;
            }
            for(int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if(newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || visited[newX][newY]) {
                    continue;
                }
                pq.offer(new int[]{grid[newX][newY], newX, newY});
                visited[newX][newY] = true;
            }
        }
        return result;
    }
}


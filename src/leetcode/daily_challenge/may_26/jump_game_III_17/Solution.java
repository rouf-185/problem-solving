package leetcode.daily_challenge.may_26.jump_game_III_17;

class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int top = queue.peek();
            queue.poll();
            if(arr[top] == 0) {
                return true;
            }
            int right = top + arr[top];
            int left = top - arr[top];
            if(right < arr.length && !visited[right]) {
                queue.offer(right);
                visited[right] = true;
            } 
            if(left >= 0 && !visited[left]) {
                queue.offer(left);
                visited[left] = true;
            } 
        }
        return false;
    }
}

package leetcode.daily_challenge.november_26.process_tasks_using_servers_1882;

public class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        // timestamp, weight, idx
        Queue<int[]> events = new PriorityQueue<>(
            (a, b)-> (a[0] == b[0] ? (a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]) : (a[0] - b[0]))
        );
        // weight, idx
        Queue<int[]> sQueue = new PriorityQueue<>(
            (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0])
        );
        for(int i = 0; i < servers.length; i++) {
            sQueue.offer(new int[]{servers[i], i});
        }
        int time = 0;
        int[] ans = new int[tasks.length];
        for(int i = 0; i < tasks.length; i++) {
            time = Math.max(i, time);
            // release all the servers those are done
            while(!events.isEmpty() && events.peek()[0] <= time) {
                int[] event = events.poll();
                sQueue.offer(new int[]{event[1], event[2]});
            }
            if(sQueue.size() == 0) {
                int[] futureEvent = events.poll();
                time = futureEvent[0];
                events.offer(new int[]{time + tasks[i], futureEvent[1], futureEvent[2]});
                ans[i] = futureEvent[2];
            } else {
                int[] server = sQueue.poll();
                events.offer(new int[]{time + tasks[i], server[0], server[1]});
                ans[i] = server[1];
            }
        }
        return ans;
    }
}

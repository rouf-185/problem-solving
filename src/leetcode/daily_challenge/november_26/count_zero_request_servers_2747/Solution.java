package leetcode.daily_challenge.november_26.count_zero_request_servers_2747;

public class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        List<int[]> list = new ArrayList<>();
        Map<Integer, Integer> queryMap = new HashMap<>();
        int k = 0;
        for(int q : queries) {
            list.add(new int[]{n + 1, q});
            queryMap.put(q, k++);
        } 
        for(int[] log : logs) {
            list.add(log);
        }
        Collections.sort(list, (a, b) -> (a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]));
        int queryPoint = n + 1;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> count = new HashMap<>();
        int[] arr = new int[queries.length];
        int arrIdx = 0;
        while(right < list.size() || arrIdx < arr.length) {
            if(list.get(right)[0] != queryPoint) {
                count.put(list.get(right)[0], count.getOrDefault(list.get(right)[0], 0) + 1);
            }            
            while(list.get(right)[1] - list.get(left)[1] > x && left < right) {
                int leftServer = list.get(left)[0];
                if(leftServer != queryPoint) {
                    if(count.get(leftServer) == 1) {
                        count.remove(leftServer);
                    } else {
                        count.put(leftServer, count.get(leftServer) - 1);
                    }
                }
                left++;
            }
            if(list.get(right)[0] == queryPoint) {
                arr[queryMap.get(list.get(right)[1])] = n - count.size();
                arrIdx++;
                if(arrIdx == arr.length) break;
            }
            right++;
        }
        return arr;
    }
}

package leetcode.meta.exclusive_time_of_functions_636;

import java.util.*;
public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        int lastTs = 0;
        for(String log : logs) {
            String[] parts = log.split(":");
            int processId =  Integer.parseInt(parts[0]);
            String event = parts[1];
            int ts = Integer.parseInt(parts[2]);
            if(event.equals("start")) {
                if(!stack.isEmpty()) {
                    result[stack.peek()] += (ts - lastTs);
                }
                stack.push(processId);
                lastTs = ts;
            } else {
                result[stack.pop()] += (ts - lastTs + 1);
                lastTs = ts + 1;
            }
            
        }
        return result;
    }
}

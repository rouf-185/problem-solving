package leetcode.meta.meeting_rooms_II_253;

import java.util.*;
public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0;
        int j = 0;
        int occupiedRooms = 0;
        int maxRoom = 0;
        while(i < start.length) {
            if(start[i] >= end[j]) {
                occupiedRooms--;
                j++;
            }
            occupiedRooms++;
            i++;
            maxRoom = Math.max(maxRoom, occupiedRooms);
        }
        return maxRoom;
    }
}

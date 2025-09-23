package leetcode.daily_challenge.september_25.compare_version_numbers_23;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = v1.length > v2.length ? v1.length : v2.length;
        for(int i = 0; i < len; i++) {
            int val1 = i >= v1.length ? 0 :  Integer.parseInt(v1[i]);
            int val2 = i >= v2.length ? 0 :  Integer.parseInt(v2[i]);
            if(val1 > val2) {
                return 1;
            } else if(val1 < val2) {
                return -1;
            }
        }
        return 0;
    }
}
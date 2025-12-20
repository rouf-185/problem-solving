package leetcode.daily_challenge.december_25.delete_columns_to_make_list_sorted;

public class Solution {
    public int minDeletionSize(String[] strs) {
        int ans = 0;
        for(int j = 0; j < strs[0].length(); j++) {
            for(int i = 1; i < strs.length; i++) {
                if(strs[i].charAt(j) < strs[i - 1].charAt(j)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}

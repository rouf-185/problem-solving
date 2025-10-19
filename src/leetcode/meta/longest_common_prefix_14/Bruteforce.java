package leetcode.meta.longest_common_prefix_14;

public class Bruteforce {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        for(int i = 0; i < strs[0].length(); i++) {
            String prefix = strs[0].substring(0, i + 1);
            for(int j = 1; j < strs.length; j++) {
                if(!strs[j].startsWith(prefix)) {
                    return ans;
                }
            }
            ans = prefix;
        }
        return ans;
    }
}

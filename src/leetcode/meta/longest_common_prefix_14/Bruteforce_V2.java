package leetcode.meta.longest_common_prefix_14;

public class Bruteforce_V2 {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}

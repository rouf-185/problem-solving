package leetcode.google.license_key_formatting;

public class Solution {
    public String licenseKeyFormatting(String s, int k) {
        List<Character> alphaneumeric = new ArrayList<>();
        for(char c : s.toCharArray()) {
            if(c == '-') continue;
            if(c >= 'a' && c <= 'z' ) {
                alphaneumeric.add((char)(c - 'a' + 'A'));
            } else {
                alphaneumeric.add(c);
            }
        }
        List<Character> ans = new ArrayList<>();
        int j = 0;
        for(int i = alphaneumeric.size() - 1; i >= 0; i--) {
            ans.add(alphaneumeric.get(i));
            j++;
            if(j % k == 0 && j < alphaneumeric.size()) {
                ans.add('-');
            }
        }
        Collections.reverse(ans);
        StringBuffer sb = new StringBuffer();
        for(char c : ans) {
            sb.append(c);
        }
        return sb.toString();
    }
}

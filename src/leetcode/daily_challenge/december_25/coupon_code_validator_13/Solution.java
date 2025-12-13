package leetcode.daily_challenge.december_25.coupon_code_validator_13;

import java.util.*;

public class Solution {
    private boolean codeIsValid(String code) {
        if(code.isEmpty()) return false;
        for(char c : code.toCharArray()) {
            if(c >= 'a' && c <= 'z') continue;
            else if(c >= 'A' && c <= 'Z') continue;
            else if(c >= '0' && c <= '9') continue;
            else if(c == '_') continue;
            else return false;
        }
        return true;
    }
    private boolean isValidBusinessLine(String line) {
        Set<String> set = new HashSet<>(Arrays.asList("electronics", "grocery", "pharmacy", "restaurant"));
        return set.contains(line);
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < code.length; i++) {
            if(!isActive[i]) continue;
            else if(!isValidBusinessLine(businessLine[i])) continue;
            else if(!codeIsValid(code[i])) continue;
            else ans.add(i);
        }
        Collections.sort(ans, (a, b) -> {
            if (businessLine[a].equals(businessLine[b])) {
                return code[a].compareTo(code[b]);
            } else {
                return businessLine[a].compareTo(businessLine[b]);
            }
        });
        List<String> ansCodes = new ArrayList<>();
        for(int idx : ans) {
            ansCodes.add(code[idx]);
        }
        return ansCodes;
    }
}

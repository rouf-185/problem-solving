package leetcode.daily_challenge.july_26.maximize_active_section_with_trade_I_3499;

public class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        s = "1" + s + "1";
        int prevZeroCount = 0;
        int currentZeroCount = 0;
        int oneCount  = 0;
        int maxContiguousZeros = 0;
        for(int i = 0; i < s.length(); i++) {
            char bit = s.charAt(i);
            if(bit == '1') {
                oneCount++;
                if(i > 0 && s.charAt(i - 1) == '0') {
                    if(prevZeroCount != 0) maxContiguousZeros = Math.max(currentZeroCount + prevZeroCount, maxContiguousZeros);
                    prevZeroCount = currentZeroCount;
                    currentZeroCount = 0;
                }
            } else {
                currentZeroCount++;
            }
        }
        return oneCount + maxContiguousZeros - 2;
    }
}

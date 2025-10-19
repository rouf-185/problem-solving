package leetcode.meta.atoi_8;

public class Solution {
    private String removeWS(String input) {
        int k = 0;
        while(k < input.length() && input.charAt(k) == ' ') {
            k++;
        }
        return k == input.length() ? "" : input.substring(k);
    }
    private String trimAllLeadingZeros(String input) {
        int k = 0;
        while(k < input.length() && input.charAt(k) == '0') {
            k++;
        }
        return k == input.length() ? "" : input.substring(k);
    }
    public int myAtoi(String input) {
        input = removeWS(input);
        if(input.isEmpty()) {
            return 0;
        }
        boolean isNegative = input.charAt(0) == '-' ? true : false;
        input =  isNegative || input.charAt(0) == '+' ? input.substring(1) : input;
        input = trimAllLeadingZeros(input);
        if(input.isEmpty()) {
            return 0;
        }
        long sum = 0;
        int mul = 1;
        int k = 0;
        while(k < input.length() && input.charAt(k) >= '0' && input.charAt(k) <= '9') {
            int digit = (int)(input.charAt(k) - '0');
            sum *= 10;
            sum += digit;
            if(isNegative) {
                if(sum >= (long) Math.pow(2, 31)) {
                    return Integer.MIN_VALUE;
                }
            } else {
                if(sum >= (long) (Math.pow(2, 31) - 1)) {
                    return Integer.MAX_VALUE;
                }
            }
            k++;
        }
        return (int)(isNegative ? -1 * sum : sum);

    }
}

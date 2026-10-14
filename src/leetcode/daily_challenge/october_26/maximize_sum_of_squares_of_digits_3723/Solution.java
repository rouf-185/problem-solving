package leetcode.daily_challenge.october_26.maximize_sum_of_squares_of_digits_3723;

public class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > (num * 9)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int remain = sum;
        for(int i = 0; i < num; i++) {
            if(remain >= 10) {
                sb.append('9');
                remain -= 9;
            } else {
                sb.append((char)(remain + '0'));
                remain = 0;
            }
        }
        return sb.toString();
    }
}

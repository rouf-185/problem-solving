package leetcode.meta.plus_one_66;

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int idx = digits.length - 1;
        while(idx >= 0){
            int newDigit = (digits[idx] + carry) % 10;
            carry = (digits[idx] + carry) / 10;
            digits[idx] = newDigit;
            idx--;
            if(carry == 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}

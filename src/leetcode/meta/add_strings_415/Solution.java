package leetcode.meta.add_strings_415;

public class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0 || carry > 0) {
            int sum = 0;
            if(i >= 0) {
                sum += (int)(num1.charAt(i) - '0');
                i--;
            } 
            if(j >= 0) {
                sum += (int)(num2.charAt(j) - '0');
                j--;
            }
            sum += carry;
            char out = (char)('0' + sum % 10);
            carry = sum / 10;
            sb.append(out);
        }
        return sb.reverse().toString();
    }
}

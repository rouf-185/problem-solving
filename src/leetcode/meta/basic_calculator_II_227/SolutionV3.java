package leetcode.meta.basic_calculator_II_227;

public class Solution {
    public int calculate(String s) {
        int lastNum = 0;
        int currentNum = 0;
        int len = s.length();
        char op = '+';
        int result = 0;
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                currentNum *= 10;
                currentNum += (int) (c - '0');
            } 
            if((!Character.isDigit(c) && !Character.isWhitespace(c)) || i == len - 1) {
                // it means end of every numbers
                if(op == '+' || op == '-') {
                    result += lastNum;
                    lastNum = (op == '-' ? (-1) * currentNum : currentNum);
                } else if(op == '*' || op == '/') {
                    lastNum =(op == '*' ? lastNum * currentNum : lastNum / currentNum);
                    // result += lastNum;
                }
                currentNum = 0;
                op = c;
            }
        }
        result += lastNum;
        return result;
    }
}

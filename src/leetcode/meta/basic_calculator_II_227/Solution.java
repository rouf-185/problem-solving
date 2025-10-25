package leetcode.meta.basic_calculator_II_227;

public class Solution {
    private int[] getNum(String s, int idx) {
        int num = 0;
        while(idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
            num *= 10;
            num += (int)(s.charAt(idx) - '0');
            idx++;
        }
        return new int[]{num, idx};
    }
    public int calculate(String s) {
        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();
        int len = s.length();
        int i = 0;
        while(i < len) {
            char c = s.charAt(i);
            if(c == '+' || c == '-' || c == '*' || c == '/') { 
                //operator
                operators.push(c);
                i++;
            } else if(c != ' ') { 
                // number detected
                int[] numsInfo = getNum(s, i);
                int num = numsInfo[0];
                i = numsInfo[1];
                if(!operators.isEmpty() && (operators.peek() == '/' || operators.peek() == '*')) {
                    int lastnum = operands.pop();
                    operands.push(operators.peek() == '/' ? lastnum / num : lastnum * num);
                    operators.pop();
                } else {
                    operands.push(num);
                }
            } else { 
                // just a whitespace
                i++;
            }
        }
        int ans = 0;
        while(!operators.isEmpty()) {
            char op = operators.pop();
            int lastnum = operands.pop();
            ans += op == '+' ? lastnum : (-1) * lastnum;
        }
        ans += operands.pop();
        return ans;
    }
}

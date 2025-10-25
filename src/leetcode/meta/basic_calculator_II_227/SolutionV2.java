package leetcode.meta.basic_calculator_II_227;

public class SolutionV2 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNum = 0;
        int len = s.length();
        char op = '+';
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                currentNum *= 10;
                currentNum += (int) (c - '0');
            } 
            if((!Character.isDigit(c) && !Character.isWhitespace(c)) || i == len - 1) {
                // it means end of every numbers
                if(op == '+') {
                    stack.push(currentNum);
                } else if(op == '-') {
                    stack.push((-1) * currentNum);
                } else if(op == '*') {
                    stack.push(stack.pop() * currentNum);
                } else {
                    stack.push(stack.pop() / currentNum);
                }
                op = c;
                currentNum = 0;
            }
        }
        int result = 0;
        while(!stack.isEmpty()) result += stack.pop();
        return result;
    }
}

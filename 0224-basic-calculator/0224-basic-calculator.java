import java.util.*;

class Solution {
    public int calculate(String s) {
        int result = 0;
        int number = 0;
        int sign = 1; // +1 or -1

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } 
            
            else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } 
            
            else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } 
            
            else if (ch == '(') {
                // push current result and sign
                stack.push(result);
                stack.push(sign);

                // reset for new expression
                result = 0;
                sign = 1;
            } 
            
            else if (ch == ')') {
                result += sign * number;
                number = 0;

                // first pop sign, then result
                result *= stack.pop(); // sign
                result += stack.pop(); // previous result
            }
        }

        // add last number
        result += sign * number;

        return result;
    }
}
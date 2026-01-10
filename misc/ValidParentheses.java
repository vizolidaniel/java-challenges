package misc;

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        // Explanation:
        // Use a stack to track opening brackets.
        // For each closing bracket, check if it matches the top of the stack.
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println("Is valid: " + vp.isValid("()[]{}")); // Expected: true
        System.out.println("Is valid: " + vp.isValid("(]"));     // Expected: false
    }
}


package dev.jessehaniel;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParentheses {

    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    // determine if the input string is valid.
    // An input string is valid if:
    // 1. Open brackets must be closed by the same type of brackets.
    // 2. Open brackets must be closed in the correct order.

    // Hash table that takes care of the mappings.
    private final Map<Character, Character> mappings = Map.of(')', '(', '}', '{',']', '[');

    public boolean isValid(String s) {
        // Initialize a stack to be used in the algorithm.
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {
                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        var app = new ValidParentheses();
        var output = app.isValid("()");
        System.out.println(output);//true
        output = app.isValid("()[]{}");
        System.out.println(output);//true
        output = app.isValid("(]");
        System.out.println(output);//false
        output = app.isValid("([)]");
        System.out.println(output);//false
        output = app.isValid("{[]}");
        System.out.println(output);//true

    }

}

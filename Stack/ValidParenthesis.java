/*
 * VALID PARENTHESES PROBLEM
 * LEETCODE LINK: https://leetcode.com/problems/valid-parentheses/
 *
 * Problem:
 * Given a string containing only parentheses: (), {}, [],
 * check whether the brackets are balanced and properly nested.
 *
 * Rules for a valid string:
 * 1. Every opening bracket must have a matching closing bracket.
 * 2. Brackets must be closed in the correct order (LIFO).
 * 3. No closing bracket can appear without a matching opening bracket.
 *
 * Approach (Stack):
 * - Use a stack to store OPENING brackets.
 * - Traverse the string from left to right.
 *
 * Steps:
 * 1. If current character is an opening bracket:
 *      → push it onto the stack.
 * 2. If current character is a closing bracket:
 *      → if stack is empty → invalid (no opening to match).
 *      → check if top of stack matches the closing bracket:
 *          - if yes → pop the opening bracket.
 *          - if no  → invalid order → return false.
 * 3. After processing the entire string:
 *      → if stack is empty → all brackets matched → valid.
 *      → else → unmatched opening brackets → invalid.
 *
 * Why Stack?
 * - Parentheses matching follows Last-In-First-Out (LIFO) order.
 * - Stack naturally models nested structures.
 *
 * Time Complexity (TC):
 * - O(n) where n is length of the string.
 *
 * Space Complexity (SC):
 * - O(n) in the worst case (all opening brackets).
 *
 * Example:
 * Input:  "({})[]()"
 * Output: true
 */

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // opening braces
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                // closing braces
                if (s.isEmpty())
                    return false;

                if ((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}')
                        || (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else
                    return false;
            }
        }

        if (s.isEmpty())
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        String str = "({})[]()";
        System.out.println(isValid(str));
    }
}

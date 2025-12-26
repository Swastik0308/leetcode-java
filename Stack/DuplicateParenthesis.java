/*
 * DUPLICATE (REDUNDANT) PARENTHESES
 *
 * Problem:
 * Given a mathematical expression, check whether it contains
 * any DUPLICATE / REDUNDANT parentheses.
 *
 * Duplicate parentheses mean:
 * - Parentheses that do NOT enclose any operator.
 *   Examples:
 *     ((a+b))   → duplicate
 *     (a)       → duplicate
 *     (a+b)     → NOT duplicate
 *
 * Approach (Stack):
 * - Use a stack to store characters.
 * - Traverse the expression from left to right.
 *
 * Key Idea:
 * - When a closing parenthesis ')' is found:
 *     → Pop elements from stack until '(' is found.
 *     → Count how many characters were inside these parentheses.
 *     → If count < 1, then no operator existed → duplicate parentheses.
 *
 * Steps:
 * 1. For every character:
 *    - If character is not ')', push it into stack.
 *    - If character is ')':
 *         a) Pop characters until '(' is encountered.
 *         b) Count popped characters (excluding '(').
 *         c) If count < 1 → duplicate parentheses found → return true.
 * 2. If entire string is processed without detecting duplicates:
 *    → return false.
 *
 * Why Stack?
 * - Helps process innermost parentheses first.
 * - Matches natural nesting of expressions.
 *
 * Time Complexity (TC):
 * - O(n) where n is the length of the string.
 *
 * Space Complexity (SC):
 * - O(n) for stack in worst case.
 *
 * Examples:
 * Input:  "((a+b))"       → true
 * Input:  "((a+b)+(c-d))" → false
 */

import java.util.Stack;

public class DuplicateParenthesis {

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // closing
            if (ch == ')') {
                int count = 0;
                while (s.pop() != '(') {
                    count++;
                }
                if (count < 1) {
                    return true; // duplicate exists
                }
            } else {
                // opening
                s.push(ch);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String str = "((a+b) + (c-d))"; // false
        String str2 = "((a+b))"; // true
        System.out.println(isDuplicate(str));
        System.out.println(isDuplicate(str2));
    }
}

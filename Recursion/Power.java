/*
LeetCode 50. Pow(x, n)

Leetcode Link: https://leetcode.com/problems/powx-n/
---------------------------------
Problem:
Implement pow(x, n), which calculates x raised to the power n (x^n).

Approach:
- Use recursion with the "divide and conquer" technique (a.k.a. fast exponentiation).
- Key idea:
    - If n is even: x^n = (x^(n/2)) * (x^(n/2))
    - If n is odd:  x^n = x * (x^(n/2)) * (x^(n/2))
- Handle negative exponents by inverting x (x = 1/x) and making n positive.
- Use long for n to avoid overflow when n = Integer.MIN_VALUE.

Complexity:
- Time Complexity: O(log n), since we reduce n by half in each step.
- Space Complexity: O(log n) due to recursion stack.

Edge Cases:
- n = 0 → return 1
- n < 0 → invert x and use positive exponent
- x = 0, x = 1, x = -1 handled naturally by recursion
*/

public class Power {

    // public static int powerOf(int x, int n) {
    // if (n == 0)
    // return 1;
    // if (n == 1)
    // return x;

    // return x * powerOf(x, n - 1);
    // }

    // public static int optimizedPowerOf(int x, int n) {
    // if (n == 0)
    // return 1;
    // if (n == 1)
    // return x;

    // int halfPower = optimizedPowerOf(x, n / 2);

    // if (n % 2 == 0) { // even
    // return halfPower * halfPower;
    // } else { // odd
    // return x * halfPower * halfPower;
    // }
    // }

    public static double myPow(double x, int n) {
        if (n == 0)
            return 1.0;

        // Handle negative powers
        if (n < 0) {
            x = 1 / x;

            return powHelper(x, -(long) n);
        }

        return powHelper(x, n);
    }

    private static double powHelper(double x, long n) {
        if (n == 0)
            return 1.0;
        double half = powHelper(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }

    public static void main(String[] args) {
        double x = 2;
        int n = 10;
        System.out.println(myPow(x, n));
    }
}

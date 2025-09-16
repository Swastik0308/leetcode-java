/*
 * Problem: Product of Array Except Self (LeetCode 238)
 * Link: https://leetcode.com/problems/product-of-array-except-self/
 *
 * Given an integer array nums, return an array answer such that answer[i] 
 * is equal to the product of all the elements of nums except nums[i].
 *
 * Approach:
 * - First compute prefix products (product of all elements before current index).
 * - Store prefix products in the result array.
 * - Then compute postfix products (product of all elements after current index)
 *   in a single reverse traversal, multiplying them into the result array.
 *
 * This avoids using division and achieves O(n) time with O(1) extra space 
 * (excluding the output array).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) (extra space)
 */

public class ProductExceptSelf {

    public static int[] calcualateProduct(int nums[]) {
        int n = nums.length;
        int ans[] = new int[n];

        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        printArray(ans);

        return ans;
    }

    public static void printArray(int ans[]) {
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4 };
        calcualateProduct(nums);

    }
}

package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/27
 * Problem 加一
 */
public class Problem_0066_PlusOne {
    /*
     * 每一位只要 < 9 直接 +1 就行，不会影响接下来的内容，如果到第一位都还没有返回出去，
     * 说明前面所有的位都有进位，需要新增一个数组来存放新的值
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }
}

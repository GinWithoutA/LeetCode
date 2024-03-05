package org.ginwithouta.leetcode.normal;

/**
 * @author Ginwithouta
 * Generate at 2023/11/30
 */
public class Problem_0007_ReverseInteger {
    public int reverse(int x) {
        /*
         * 用负数来做运算，因为负数比正数能够多表示一个，在计算的时候需要小心防止溢出
         */
        boolean neg = ((x >>> 31) & 1) == 1;
        x = neg ? x : -x;
        int res = 0;
        while (x != 0) {
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && x % 10 < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return neg ? res : Math.abs(res);
    }
}

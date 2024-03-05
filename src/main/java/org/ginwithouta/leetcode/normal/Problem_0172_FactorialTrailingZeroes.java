package org.ginwithouta.leetcode.normal;

/**
 * @author Ginwithouta
 * Generate at 2024/1/28
 * Problem 阶乘后的零
 */
public class Problem_0172_FactorialTrailingZeroes {
    public int trailingZeros(int n) {
        /*
         * 阶乘末尾的 0 一定是由阶乘分解中 2 和 5 的因子决定的。由于 5 大于 2 ，出现了 5 就肯定有一个 2 与之匹配，
         * 就一定会产生一个 0。所以我们只需要计算 5 的个数就可以。此外，超过 25 的时候，5 的因子就会多一个，超过
         * 5 * 5 * 5 的时候，又会多一个，因此我们需要不断反复除以 5 ，直到 n 变为 0 为止，就是总的 0 的个数
         */
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}

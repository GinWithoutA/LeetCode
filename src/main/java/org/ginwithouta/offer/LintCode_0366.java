package org.ginwithouta.offer;

/**
 * @author Ginwithouta
 * Generate at 2024/3/7
 * LintCode 剑指 Offer 斐波那契数列
 */
public class LintCode_0366 {
    public int fibonacci(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int pre = 1, prePre = 0, cur = 0;
        for (int i = 3; i <= n; ++i) {
            cur = pre + prePre;
            prePre = pre;
            pre = cur;
        }
        return cur;
    }
}

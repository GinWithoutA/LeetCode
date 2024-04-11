package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/4/11
 * LeetCode 面试经典 150 爬楼梯
 */
public class LeetCode_Interview_137_ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int prev = 2, prevPrev = 1, ans = 0;
        for (int i = 3; i <= n; ++i) {
            ans = prev + prevPrev;
            prevPrev = prev;
            prev = ans;
        }
        return ans;
    }
}

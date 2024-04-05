package org.ginwithouta.leetcode.interview150;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ginwithouta
 * Generate at 2024/4/5
 * LeetCode 面试经典 150 快乐数
 */
public class LeetCode_Interview_045_HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n) && n != 1) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}

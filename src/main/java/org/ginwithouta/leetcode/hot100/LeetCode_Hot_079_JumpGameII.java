package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/3/6
 * LeetCode Hot 100 跳跃游戏Ⅱ
 */
public class LeetCode_Hot_079_JumpGameII {
    public int jump(int[] nums) {
        int mostRight = nums[0], count = 0, cur = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (i > cur) {
                ++count;
                cur = mostRight;
            }
            mostRight = Math.max(mostRight, i + nums[i]);
        }
        return count;
    }
}

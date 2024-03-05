package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/17
 * LeetCode Hot 100 移动零
 */
public class LeetCode_Hot_004_MoveZeros {
    public void moveZeros(int[] nums) {
        int idx = 0, cur = 0;
        while (idx < nums.length) {
            if (nums[idx] != 0) {
                nums[cur] = nums[idx];
                if (idx != cur) {
                    nums[idx] = 0;
                }
                ++idx;
                ++cur;
            } else {
                ++idx;
            }
        }
    }
}

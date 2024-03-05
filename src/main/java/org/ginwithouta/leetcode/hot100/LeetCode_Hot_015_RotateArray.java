package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/18
 * LeetCode Hot 100 轮转数组
 */
public class LeetCode_Hot_015_RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums.length == 1 || k == 0 || k % nums.length == 0) {
            return;
        }
        int real = k < nums.length ? k : k % nums.length;
        boolean[] flag = new boolean[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (!flag[i]) {
                flag[i] = true;
                int idx = (i + real) % nums.length, prev = nums[i], temp;
                while (!flag[idx]) {
                    flag[idx] = true;
                    temp = nums[idx];
                    nums[idx] = prev;
                    prev = temp;
                    idx = (idx + real) % nums.length;
                }
                nums[idx] = prev;
            }
        }
    }

    /**
     * 优化
     */
    public void rotateOptimization(int[] nums, int k) {
        if (nums.length == 1 || k == 0 || k % nums.length == 0) {
            return;
        }
        int real = k < nums.length ? k : k % nums.length, count = 0, prev;
        for (int i = 0; i < nums.length && count < nums.length; ++i) {
            int cur = i, temp = nums[i];
            do {
                prev = temp;
                cur = (cur + real) % nums.length;
                temp = nums[cur];
                nums[cur] = prev;
                ++count;
            } while (cur != i);
        }
    }
}

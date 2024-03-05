package org.ginwithouta.leetcode.normal;

/**
 * @author Ginwithouta
 * Generate at 2023/12/4
 * Problem 轮转数组
 */
public class Problem_0189_RotateArray {

    public void rotate(int[] nums, int k) {
        /*
         * 这道题可以发现：
         * 1）如果数组长度是奇数，那么从 0 开始每个数轮一次回到 0 ，就完成了转换
         * 2）如果数组长度是偶数，那么以 0 位置开头只能循环部分的元素，需要遍历数组
         */
        int count = 0, cur, temp, prev;
        for (int start = 0; start < nums.length && count < nums.length; ++start) {
            cur = start;
            temp = nums[start];
            do {
                prev = temp;
                cur = (cur + k) % nums.length;
                temp = nums[cur];
                nums[cur] = prev;
                ++count;
            } while (cur != start);
            nums[cur] = prev;
        }
    }
}

package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/30
 * LeetCode 面试经典 150 两数之和Ⅱ 输入有序数组
 */
public class LeetCode_Interview_027_TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                --right;
            } else if (numbers[left] + numbers[right] < target) {
                ++left;
            } else {
                return new int[] {left + 1, right + 1};
            }
        }
        return null;
    }
}

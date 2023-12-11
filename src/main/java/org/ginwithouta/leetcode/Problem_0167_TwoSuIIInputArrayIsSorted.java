package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/12/11
 * Problem 两数之和Ⅱ 输入有序数组
 */
public class Problem_0167_TwoSuIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        /*
         * 经典双指针问题，由于是已经排列好的数组，那么对于数组中两个数的和，我们可以定义两个指针分别从左从右往里面遍历
         * 若当前双指针的和大于 target ，说明是右指针太大，往里走
         * 若当前双指针的和小于 target ，说明是左指针太小，往里走
         */
        if (numbers.length == 2) {
            return new int[] {1, 2};
        }
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

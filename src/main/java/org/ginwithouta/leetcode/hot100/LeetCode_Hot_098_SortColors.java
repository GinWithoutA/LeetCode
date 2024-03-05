package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/19
 * LeetCode Hot 100 颜色分类
 */
public class LeetCode_Hot_098_SortColors {
    public void sortColors(int[] nums) {
        /*
         * 三色国旗问题，要有三个变量，一个是小于区的边界，一个是大于区的边界，另一个是当前位置
         */
        int less = -1, more = nums.length, index = 0;
        while (index < more) {
            if (nums[index] == 1) {
                ++index;
            } else if (nums[index] < 1) {
                if (++less == index) {
                    ++index;
                } else {
                    swap(nums, less, index);
                }
            } else {
                swap(nums, index, --more);
            }
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

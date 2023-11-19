package org.ginwithouta.leetcode;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2023/11/19
 */
public class Problem_0215_KthLargestElementInAnArray {
    /**
     * 经典解法
     */
    public int findKthLargest(int[] nums, int k) {
        /*
         * 笔试真碰到了，别想那么多，直接这么写
         * 这种方法已经是最优解，复杂度 O(N)
         */
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 荷兰国旗问题的非递归版本
     */
    public int better(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1, pivot, target = nums.length - k;
        int [] range;
        while (left < right) {
            pivot = nums[left + (int) (Math.random() * (right - left + 1))];
            range = partition(nums, left, right, pivot);
            if (target < range[0]) {
                right = range[0] - 1;
            } else if (target > range[1]) {
                left = range[1] + 1;
            } else {
                return nums[target];
            }
        }
        // left 不可能大于 right，因为区间肯定是在 [left, right] 上，而目标值也是在 [left, right] 上，就一定保证当经历到某一次查找的时候，要么就是被 range 覆盖，要么就是只剩一个元素
        // 出循环说明 left == right，此时直接返回 nums[left] 就是最终答案
        return nums[left];
    }

    public int[] partition(int[] nums, int left, int right, int pivot) {
        /*
         * 荷兰国旗在排序的时候会将元素放在最终的位置上，利用这一点，我们可以在计算的过程中就得到想要的值
         */
        int more = right, less = left - 1, index = left;
        // 这里需要判断 index 是否等于 more，因为 more 前进的时候是 more-- ，那么操作完成之后的 more 位置的值是还没有看的
        while (index <= more) {
            if (nums[index] < pivot) {
                swap(nums, ++less, index++);
            } else if (nums[index] == pivot) {
                ++index;
            } else {
                swap(nums, index, more--);
            }
        }
        return new int[] {less + 1, more};
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

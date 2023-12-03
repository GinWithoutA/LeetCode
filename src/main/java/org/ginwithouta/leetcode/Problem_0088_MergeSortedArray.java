package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/12/3
 * Problem 合并两个有序数组
 */
public class Problem_0088_MergeSortedArray {

    /**
     * 合并两个有序数组
     * @param nums1 数组 1
     * @param m     数组 1 的长度
     * @param nums2 数组 2
     * @param n     数组 2 的长度
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
         * 这道题如果正着做，就需要不断记录 nums1 被覆盖的部分，因此可以反过来，倒着做，先利用 nums1 后面几个为空的数据
         * 能够省去几个临时变量的定义
         */
        while (m > 0 && n > 0) {
            nums1[m + n - 1] = nums1[m - 1] >= nums2[n - 1] ? nums1[--m] : nums2[--n];
        }
        while (m > 0) {
            nums1[m + n - 1] = nums1[--m];
        }
        while (n > 0) {
            nums1[m + n - 1] = nums2[--n];
        }
    }
}

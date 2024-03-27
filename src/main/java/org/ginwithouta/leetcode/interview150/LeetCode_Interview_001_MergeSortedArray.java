package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/27
 * LeetCode 面试经典 150 合并两个有序数组
 */
public class LeetCode_Interview_001_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[idx--] = nums1[m-- - 1];
            } else {
                nums1[idx--] = nums2[n-- - 1];
            }
        }
        while (m > 0) {
            nums1[idx--] = nums1[m-- - 1];
        }
        while (n > 0) {
            nums1[idx--] = nums2[n-- - 1];
        }
    }
}

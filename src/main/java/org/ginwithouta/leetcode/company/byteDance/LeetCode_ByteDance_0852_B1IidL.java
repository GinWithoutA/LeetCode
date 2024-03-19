package org.ginwithouta.leetcode.company.byteDance;

/**
 * @author Ginwithouta
 * Generate at 2024/3/16
 * LeetCode 字节跳动 山脉数组的峰顶索引
 */
public class LeetCode_ByteDance_0852_B1IidL {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1, right = arr.length - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= arr[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

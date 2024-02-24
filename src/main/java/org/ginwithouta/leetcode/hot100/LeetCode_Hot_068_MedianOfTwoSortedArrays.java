package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/24
 * LeetCode Hot 100 寻找两个正序数组的中位数
 */
public class LeetCode_Hot_068_MedianOfTwoSortedArrays {
    public double finMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        boolean even = (size & 1) == 0;
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        } else if (nums1.length != 0 && nums2.length != 0) {
            if (even) {
                return (double) (findKthNum(nums1, nums2, size / 2) + findKthNum(nums1, nums2, size / 2 + 1)) / 2;
            } else {
                return findKthNum(nums1, nums2, size / 2 + 1);
            }
        } else if (nums1.length == 0) {
            if (even) {
                return (double) (nums2[(nums2.length - 1) / 2] + nums2[nums2.length / 2]) / 2;
            } else {
                return nums2[nums2.length / 2];
            }
        } else {
            if (even) {
                return (double) (nums1[(nums1.length - 1) / 2] + nums1[nums1.length / 2]) / 2;
            } else {
                return nums1[nums1.length / 2];
            }
        }
    }

    public int findKthNum(int[] nums1, int[] nums2, int kth) {
        int[] longs = nums1.length >= nums2.length ? nums1 : nums2;
        int[] shorts = longs == nums1 ? nums2 : nums1;
        if (kth <= shorts.length) {
            return getUpMedian(shorts, 0, kth - 1, longs, 0, kth - 1);
        } else if (kth > longs.length) {
            int shortLeft = kth - longs.length - 1, longLeft = kth - shorts.length - 1;
            if (shorts[shortLeft] >= longs[longs.length - 1]) {
                return shorts[shortLeft];
            }
            if (longs[longLeft] >= shorts[shorts.length - 1]) {
                return longs[longLeft];
            }
            return getUpMedian(shorts, shortLeft + 1, shorts.length - 1, longs, longLeft + 1, longs.length - 1);
        } else {
            int longLeft = kth - shorts.length - 1, longRight = kth - 1;
            if (longs[longLeft] >= shorts[shorts.length - 1]) {
                return longs[longLeft];
            }
            return getUpMedian(shorts, 0, shorts.length - 1, longs, longLeft + 1, longRight);
        }
    }

    /**
     * 查找两个数组合并后的中位数，两个数组需要合并的长度相同
     */
    public int getUpMedian(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2) {
        int mid1, mid2;
        while (left1 < right1) {
            mid1 = (left1 + right1) / 2;
            mid2 = (left2 + right2) / 2;
            // 如果两个数组中位数相等，那么合并后的中位数就是这个数
            if (nums1[mid1] == nums2[mid2]) {
                return nums1[mid1];
            }
            if (((right1 - left1 + 1) & 1) == 1) {
                if (nums1[mid1] > nums2[mid2]) {
                    if (nums1[mid1 - 1] <= nums2[mid2]) {
                        return nums2[mid2];
                    }
                    right1 = mid1 - 1;
                    left2 = mid2 + 1;
                } else {
                    if (nums1[mid1] >= nums2[mid2 - 1]) {
                        return nums1[mid1];
                    }
                    right2 = mid2 - 1;
                    left1 = mid1 + 1;
                }
            } else {
                if (nums1[mid1] > nums2[mid2]) {
                    right1 = mid1;
                    left2 = mid2 + 1;
                } else {
                    left1 = mid1 + 1;
                    right2 = mid2;
                }
            }
        }
        return Math.min(nums1[left1], nums2[left2]);
    }
}

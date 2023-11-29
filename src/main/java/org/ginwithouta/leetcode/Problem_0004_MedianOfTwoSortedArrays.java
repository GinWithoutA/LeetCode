package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/11/29
 * Problem 求两个升序数组的中位数
 */
public class Problem_0004_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
         * 整个方法重构为找到两个数组中的第 k 个数，而不是中位数
         */
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

    /**
     * 找到两个数组合并后的第 k 个数
     * @param arr1  数组1
     * @param arr2  数组2
     * @param k     第 k 个数
     * @return      返回合并后的第 k 个数
     */
    public static int findKthNum(int[] arr1, int[] arr2, int k) {
        /*
         * 找到两个数组合并后的第 k 个数，存在三种情况：
         *  1）k 小于短数组的长度，也就是说最终的 k 的位置在两个数组的内部，这种情况直接去找两个数组中 0 到 k 的上中位数
         *  2）k 大于短数组的长度，但是小于长数组的长度
         *  3）k 大于短数组和长数组的长度，但是小于短数组和长数组的长度之和
         */
        int[] shorts = arr1.length <= arr2.length ? arr1 : arr2;
        int[] longs = shorts == arr1 ? arr2 : arr1;
        if (k <= shorts.length) {
            return getUpperMedian(shorts, 0, k - 1, longs, 0, k - 1);
        } else if (k <= longs.length) {
            /*
             * 对应情况 2 ，此时短数组的所有位置都有可能是 k 位置的数，长数组中
             *  1）k - 短数组长度 - 1 范围内都不可能是 k 位置的数
             *  2）k 位置之后的数不可能是 k 位置的数
             * 为了能调用下面的函数，需要单独判断长数组 longsLeft 的数是不是 k 位置的数
             */
            int longsLeft = k - shorts.length - 1, longsRight = k - 1;
            if (longs[longsLeft] >= shorts[shorts.length - 1]) {
                return longs[longsLeft];
            }
            return getUpperMedian(shorts, 0, shorts.length - 1, longs, longsLeft + 1, longsRight);
        } else {
            /*
             * 对应情况 3 ，此时短数组中从 k - 长数组长度 - 1 开始的数有可能是 k 位置的数
             * 长数组中从 k - 短数组长度 - 1 开始到结束所有的数都有可能是 k 位置的数
             * 最后为了能够求到 k 位置的数，需要手动删除两个数
             */
            int shortsLeft = k - longs.length - 1, longsLeft = k - shorts.length - 1;
            if (shorts[shortsLeft] >= longs[longs.length - 1]) {
                return shorts[shortsLeft];
            }
            if (longs[longsLeft] >= shorts[shorts.length -1]) {
                return longs[longsLeft];
            }
            return getUpperMedian(shorts, shortsLeft + 1, shorts.length - 1, longs, longsLeft + 1, longs.length - 1);
        }
    }

    /**
     * 求给定两个数组的指定范围中的上中位数
     * @param arr1  数组1
     * @param s1    数组1的左边界
     * @param e1    数组2的右边界
     * @param arr2  数组2
     * @param s2    数组2的左边界
     * @param e2    数组2的右边界
     * @return      两个数组的上中位数
     */
    public static int getUpperMedian(int[] arr1, int s1, int e1, int[] arr2, int s2, int e2) {
        /*
         * 分别找到两个数组的上中位数，然后递归调用
         */
        int mid1, mid2;
        while (s1 < e1) {
            mid1 = (s1 + e1) / 2;
            mid2 = (s2 + e2) / 2;
            // 如果两个数组的上中位数相等，那么合并后的上中位数就是这两个数的其中一个
            if (arr1[mid1] == arr2[mid2]) {
                return arr1[mid1];
            }
            // 如果两个数组是奇数长度
            if (((e1 - s1 + 1) & 1) == 1) {
                /*
                 * 当 arr1 的中位数 大于 arr2 的中位数，那么最终可能是中位数的范围就只能是 arr1 中位数左边，arr2 中位数右边
                 */
                if (arr1[mid1] > arr2[mid2]) {
                    if (arr1[mid1 - 1] <= arr2[mid2]) {
                        return arr2[mid2];
                    }
                    e1 = mid1 - 1;
                    s2 = mid2 + 1;
                } else {
                    if (arr1[mid1] >= arr2[mid2 - 1]) {
                        return arr1[mid1];
                    }
                    s1 = mid1 + 1;
                    e2 = mid2 - 1;
                }
            } else {
                // 偶数长度
                if (arr1[mid1] > arr2[mid2]) {
                    e1 = mid1;
                    s2 = mid2 + 1;
                } else {
                    s1 = mid1 + 1;
                    e2 = mid2;
                }
            }
        }
        return Math.min(arr1[s1], arr2[s2]);
    }
}

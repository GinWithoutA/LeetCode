package org.ginwithouta.leetcode.company.mi;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/3/12
 * LeetCode 小米 构造最长非递减子数组
 */
public class LeetCode_Mi_2771_LongestNonDecreasingSubarrayFromTwoArrays {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        /*
         * 维护两个dp，分别表示nums1和nums2到当前位置的最长非递减序列长度
         * 同时判断是否能够拼接，并用另两个变量来存储过程中的最大值
         */
        if (nums1.length == 1) {
            return 1;
        }
        int[] dp1 = new int[nums1.length];
        int[] dp2 = new int[nums2.length];
        int max1 = 1, max2 = 1;
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for (int i = 1; i < nums1.length; ++i) {
            if (nums1[i] >= nums1[i - 1]) {
                dp1[i] = Math.max(dp1[i], dp1[i - 1] + 1);
            }
            if (nums1[i] >= nums2[i - 1]) {
                dp1[i] = Math.max(dp1[i], dp2[i - 1] + 1);
            }
            if (nums2[i] >= nums2[i - 1]) {
                dp2[i] = Math.max(dp2[i], dp2[i - 1] + 1);
            }
            if (nums2[i] >= nums1[i - 1]) {
                dp2[i] = Math.max(dp2[i], dp1[i - 1] + 1);
            }
            max1 = Math.max(max1, dp1[i]);
            max2 = Math.max(max2, dp2[i]);
        }
        return Math.max(max1, max2);
    }


}

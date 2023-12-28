package org.ginwithouta.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ginwithouta
 * Generate at 2023/12/28
 * Problem 最长连续序列
 */
public class Problem_0128_LongestConsecutiveSequence {
    /**
     * 自己想的方法
     */
    public int longestConsecutive(int[] nums) {
        /*
         * 由于需要连续递增的序列，而元素在原数组中的位置有无所谓，因此可以先将原数组排序一下，此时所有的元素就相当于划分成了不同的区间，接下来就是看最长的区间是哪个
         * 从第二个元素遍历，如果当前元素比和前一个元素相差 1 ，那么当前区间长度 +1 ，如果当前元素和前一个元素相等，那么就只增加下标。
         *
         * 要注意一点，由于每次都是从第二个元素开始判断，因此当循环跳出的时候，也需要让下标 +1
         */
        if (nums.length < 2) return nums.length;
        Arrays.sort(nums);
        int len = 0, cur = 1, right = 1;
        while (right < nums.length) {
            while (right < nums.length && (nums[right] == nums[right - 1] || nums[right] == nums[right - 1] + 1)) {
                if (nums[right] != nums[right - 1]) {
                    ++cur;
                }
                ++right;
            }
            len = Math.max(len, cur);
            cur = 1;
            ++right;
        }
        return len;
    }

    /**
     * 题解方法
     */
    public int longestConsecutiveAnother(int[] nums) {
        /*
         * 首先我们对数组中的元素去重，然后主逻辑针对当前数 num ，不断查看 num++ 在不在数组中，如果在就长度加 1 ，最后找到最长的长度
         * 同时，如果 num - 1 在数组中，说明当前数已经被归纳到某一个连续的序列中了，当前序列中的所有数字都不用再遍历了
         */
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int count = 0;
            while (set.contains(num++)) {
                ++count;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}

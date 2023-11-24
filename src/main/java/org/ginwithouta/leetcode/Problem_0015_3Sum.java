package org.ginwithouta.leetcode;

import java.util.*;

/**
 * @author Ginwithouta
 * Generate at 2023/11/24
 * Problem 三数之和
 */
public class Problem_0015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
         * 将数组首先进行一次排序，保证相同的数字一定会相邻出现，然后每次确定一个数，剩下的就变成两数之和问题
         * 在确定每个数的时候，要保证当前的数和上一组数不等，这样子就能保证不会找到相同的答案
         */
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = nums.length - 1; i > 1; --i) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                List<List<Integer>> res = twoSum(nums, -nums[i], i - 1);
                for (List<Integer> item : res) {
                    item.add(nums[i]);
                    ans.add(item);
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int end) {
        /*
         * 两数之和的另一种解法，在添加答案的时候也需要判断当前的数和上一次判断的数是否相同，这样就能保证不会
         * 收集到相同的答案
         */
        int left = 0, right = end;
        List<List<Integer>> res = new ArrayList<>();
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                ++left;
            } else if (nums[left] + nums[right] > target) {
                --right;
            } else {
                if (left == 0 || nums[left - 1] != nums[left]) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[left]);
                    item.add(nums[right]);
                    res.add(item);
                }
                ++left;
            }
        }
        return res;
    }
}

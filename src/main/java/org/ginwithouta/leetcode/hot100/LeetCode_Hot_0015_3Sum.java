package org.ginwithouta.leetcode.hot100;

import java.util.*;

/**
 * @author Ginwithouta
 * Generate at 2024/2/17
 * LeetCode Hot 100 盛水最多的容器
 */
public class LeetCode_Hot_0015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 1; --i) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                List<List<Integer>> res = twoSum(nums, i - 1, -nums[i]);
                for (List<Integer> item : res) {
                    item.add(nums[i]);
                    ans.add(item);
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> twoSum(int[] nums, int right, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int left = 0;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                --right;
            } else if (nums[left] + nums[right] < target) {
                ++left;
            } else {
                if (left == 0 || nums[left] != nums[left - 1]) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[left]);
                    res.add(nums[right]);
                    ans.add(res);
                }
                ++left;
            }
        }
        return ans;
    }
}

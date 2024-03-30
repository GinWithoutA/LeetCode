package org.ginwithouta.leetcode.interview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/3/30
 * LeetCode 面试经典 150 三数之和
 */
public class LeetCode_Interview_029_TreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
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

    public List<List<Integer>> twoSum(int[] nums, int end, int target) {
        int left = 0;
        List<List<Integer>> ans = new ArrayList<>();
        while (left < end) {
            if (nums[left] + nums[end] > target) {
                --end;
            } else if (nums[left] + nums[end] < target) {
                ++left;
            } else {
                if (left == 0 || nums[left] != nums[left - 1]) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[left]);
                    item.add(nums[end]);
                    ans.add(item);
                }
                ++left;
                --end;
            }
        }
        return ans;
    }
}

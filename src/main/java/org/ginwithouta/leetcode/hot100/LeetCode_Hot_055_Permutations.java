package org.ginwithouta.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/2/22
 * LeetCode Hot 100 全排列
 */
public class LeetCode_Hot_055_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        process(ans, path, nums, 0);
        return ans;
    }
    public void process(List<List<Integer>> ans, List<Integer> path, int[] nums, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < nums.length; ++i) {
            swap(nums, index, i);
            path.add(nums[index]);
            process(ans, path, nums, index + 1);
            path.remove(path.size() - 1);
            swap(nums, index, i);
        }
    }
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

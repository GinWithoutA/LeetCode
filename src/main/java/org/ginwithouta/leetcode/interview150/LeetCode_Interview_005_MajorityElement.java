package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/27
 * LeetCode 面试经典 150 多数元素
 */
public class LeetCode_Interview_005_MajorityElement {
    public int majorityElement(int[] nums) {
        int hp = 1, ans = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == ans) {
                ++hp;
            } else if (hp == 0) {
                hp = 1;
                ans = nums[i];
            } else {
                --hp;
            }
        }
        return ans;
    }
}

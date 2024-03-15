package org.ginwithouta.leetcode.company.byteDance;

/**
 * @author Ginwithouta
 * Generate at 2024/3/15
 * LeetCode 字节跳动 多数元素
 */
public class LeetCode_ByteDance_0169_MajorityElement {
    public int majorityElement(int[] nums) {
        int hp = 1, cur = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == cur) {
                ++hp;
            } else if (hp == 0) {
                hp = 1;
                cur = nums[i];
            } else {
                --hp;
            }
        }
        return cur;
    }
}

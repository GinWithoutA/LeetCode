package org.ginwithouta.leetcode.company.mi;


/**
 * @author Ginwithouta
 * Generate at 2024/3/12
 * LeetCode 小米 多数元素
 */
public class LeetCode_Mi_0169_MajorityElement {
    public int majorityElement(int[] nums) {
        int hp = 1, target = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == target) {
                ++hp;
            } else if (hp == 0) {
                hp = 1;
                target = nums[i];
            } else {
                --hp;
            }
        }
        return target;
    }
}

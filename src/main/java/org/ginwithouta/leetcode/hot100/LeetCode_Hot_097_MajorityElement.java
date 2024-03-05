package org.ginwithouta.leetcode.hot100;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/2/19
 * LeetCode Hot 100 多数元素
 */
public class LeetCode_Hot_097_MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int cur = nums[0], count = 1, ans = nums[0], maxCount = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == cur) {
                ++count;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    ans = cur;
                }
                count = 1;
                cur = nums[i];
            }
        }
        return count > maxCount ? cur : ans;
    }

    public int majorityElementOptimization(int[] nums) {
        /*
         * 把每个值对应的数量想象成生命值，数量多的那个最后肯定会剩生命值，这就是我们要的答案
         */
        int hp = 1, target = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == target) {
                ++hp;
            } else if (hp == 0) {
                ++hp;
                target = nums[i];
            } else {
                --hp;
            }
        }
        return target;
    }
}

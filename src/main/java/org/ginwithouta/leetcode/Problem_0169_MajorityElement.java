package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/12/4
 * Problem 返回数组中的多数元素（出现次数大于 n / 2）
 */
public class Problem_0169_MajorityElement {
    public int majorityElement(int[] nums) {
        /*
         * 这个数出现次数大于 n / 2 ，因此我们可以考虑给当前遍历到的数设置一个 hp ，如果后续遍历到相同的数， ++hp
         * 如果遍历到不同的数 --hp ，当 hp == 0 ，就把 hp 给下一个数，最终一定只有目标数的 hp 是正数
         */
        int hp = 1, target = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (hp == 0) {
                ++hp;
                target = nums[i];
            } else if (nums[i] == target) {
                ++hp;
            } else {
                --hp;
            }
        }
        return target;
    }
}

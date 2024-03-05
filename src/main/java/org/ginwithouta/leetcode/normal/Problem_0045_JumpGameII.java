package org.ginwithouta.leetcode.normal;

/**
 * @author Ginwithouta
 * Generate at 2023/12/5
 */
public class Problem_0045_JumpGameII {
    public int jump(int[] nums) {
        /*
         * 这题的目标是求能跳到最后一个位置的最小步数，因此对于 maxRight，我们应该保证在当前的 maxRight 内能推高最多的 maxRight
         * 因此需要一个额外的变量，记录记录范围内能够推高的最大 maxRight
         */
        int count = 0, maxRight = nums[0], nextMove = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (i > nextMove) {
                ++count;
                nextMove = maxRight;
            }
            maxRight = Math.max(maxRight, i + nums[i]);
        }
        return count;
    }
}

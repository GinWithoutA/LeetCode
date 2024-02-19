package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/19
 * LeetCode Hot 100 寻找重复数
 */
public class LeetCode_Hot_0287_FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        /*
         * 由于数组中的所有数字都是在 1, n ，因此可以把这个数组想做是一个有环链表，每个位置 i 指向 nums[i]，
         * 那么重复元素一定存在多个入边，这个就是我们需要的答案
         */
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

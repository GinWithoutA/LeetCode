package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/19
 * LeetCode Hot 100 下一个排列
 */
public class LeetCode_Hot_0031_NextPermutation {
    public void nextPermutation(int[] nums) {
        /*
         * 如何得到这样的排列顺序？这是本文的重点。我们可以这样来分析：
         * 我们希望下一个数 比当前数大，这样才满足 “下一个排列” 的定义。因此只需要 将后面的「大数」与前面的「小数」交换，
         * 就能得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
         * 我们还希望下一个数 增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需
         * 要在尽可能靠右的低位 进行交换，需要 从后向前 查找将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，
         * 下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换将「大数」换到前面后，需要将「大数」后面的所有数 重置为升序，
         * 升序排列就是最小的排列。以 123465 为例：首先按照上一步，交换 5 和 4，得到 123564；然后需要将 5 之后的数重置为
         * 升序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列
         */
        if (nums.length == 1) {
            return;
        }
        int firstIncrease = nums.length - 2;
        while (firstIncrease >= 0 && nums[firstIncrease] >= nums[firstIncrease + 1]) {
            --firstIncrease;
        }
        if (firstIncrease < 0) {
            reverse(nums, 0, nums.length - 1);
        }
        for (int j = nums.length - 1; j > firstIncrease;) {
            if (nums[j] > nums[firstIncrease] || --j == firstIncrease) {
                swap(nums, firstIncrease, j);
                reverse(nums, firstIncrease + 1, nums.length - 1);
                return;
            }
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void reverse(int[] nums, int start, int end) {
        if (start < end) {
            while (start < end) {
                swap(nums, start++, end--);
            }
        }
    }
}

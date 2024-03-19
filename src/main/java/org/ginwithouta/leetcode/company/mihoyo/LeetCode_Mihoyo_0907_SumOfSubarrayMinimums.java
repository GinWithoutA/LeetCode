package org.ginwithouta.leetcode.company.mihoyo;

/**
 * @author Ginwithouta
 * Generate at 2024/3/16
 * LeetCode 米哈游 子数组的最小值之和
 */
public class LeetCode_Mihoyo_0907_SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        /*
         * 假设每个位置是当前能构成的子数组的最小值，从而我们可以构建一个单调栈，来处理
         * 要保证栈内的元素是递增的，如果加入的元素比栈顶元素小，则弹出，弹出的时候一起
         * 计算当前弹出元素能够组成的子数组区间长度（弹出元素到栈顶元素的距离以及弹出元
         * 素与当前遍历到的元素的距离）
         */
        int mod = 1000000007, top = -1;
        long sum = 0L;
        int[] stack = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            while (top != -1 && arr[stack[top]] >= arr[i]) {
                int cur = stack[top--];
                sum += (long) (top == -1 ? cur + 1 : cur - stack[top]) * (i - cur) * arr[cur];
                sum %= mod;
            }
            stack[++top] = i;
        }
        while (top != -1) {
            int cur = stack[top--];
            sum += (long) (top == -1 ? cur + 1 : cur - stack[top]) * (arr.length - cur) * arr[cur];
            sum %= mod;
        }
        return (int) sum;
    }
}

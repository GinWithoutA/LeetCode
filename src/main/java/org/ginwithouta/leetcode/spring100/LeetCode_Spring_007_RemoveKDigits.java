package org.ginwithouta.leetcode.spring100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ginwithouta
 * Generate at 2024/3/21
 * LeetCode 春招 100 移掉 K 位数字
 */
public class LeetCode_Spring_007_RemoveKDigits {
    public static String removeKDigits(String num, int k) {
        /*
         * 首先找到解题思路，要使得移除之后的数字最小，就需要从左到右移除较大的数，也就是逆序对中的前一个数
         * 因此简单的思路就是只要找到逆序对，那么就删除前面的数，再判断当前是否为逆序对。可以发现没删除一个
         * 就需要和前面所有的数字作比较，因此这个操作可以利用单调栈进行加速，单调栈中的元素非递减，每加入就
         * 需要判断栈顶元素。
         */
        char[] nums = num.toCharArray();
        Deque<Character> queue = new ArrayDeque<>();
        for (char c : nums) {
            while (!queue.isEmpty() && queue.peekLast() > c && k > 0) {
                --k;
                queue.pollLast();
            }
            queue.offerLast(c);
        }
        while (k != 0) {
            queue.pollLast();
            --k;
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty() && queue.peekFirst() == '0') {
            queue.pollFirst();
        }
        while (!queue.isEmpty()) {
            sb.append(queue.pollFirst());
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }
}

package org.ginwithouta.leetcode.company.byteDance;

/**
 * @author Ginwithouta
 * Generate at 2024/3/15
 * LeetCode 字节跳动 反转字符串
 */
public class LeetCode_ByteDance_0344_ReverseString {
     public void reverseString(char[] s) {
         int left = 0, right = s.length - 1;
         while (left < right) {
             swap(s, left++, right--);
         }
     }
     public void swap(char[] s, int left, int right) {
         char temp = s[left];
         s[left] = s[right];
         s[right] = temp;
     }
}

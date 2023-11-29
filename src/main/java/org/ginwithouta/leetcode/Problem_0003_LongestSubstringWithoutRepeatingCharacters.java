package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/11/29
 * Problem 无重复字符的最长字串
 */
public class Problem_0003_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String str) {
        /*
         * 能影响答案的因素，只有两个
         *  1）当前元素上一次出现的位置
         *  2）前一个元素构建了多长的无重复字串
         * 利用这两个因素，每次只选取离自己更近的那个因素，就是当前元素能够产生的答案
         */
        int[] map = new int[256];
        for (int i = 0; i < 256; ++i) {
            map[i] = -1;
        }
        // pre 表示 i - 1 位置为结尾的情况下，往左边推，推到哪个位置推不动了
        int pre = -1;
        int cur, length = 0;
        for (int i = 0; i < str.length(); ++i) {
            pre = Math.max(pre, map[str.charAt(i)]);
            cur = i - pre;
            map[str.charAt(i) - 'a'] = i;
            length = Math.max(length, cur);
        }
        return length;
    }
}

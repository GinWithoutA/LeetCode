package org.ginwithouta.leetcode.normal;

import java.util.Arrays;

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
            // 先找到当前最远能推到左边的哪个位置，要么就是 pre ，要么就是当前元素上一次出现的位置
            pre = Math.max(pre, map[str.charAt(i)]);
            cur = i - pre;
            map[str.charAt(i)] = i;
            length = Math.max(length, cur);
        }
        return length;
    }

    /**
     * 解法2
     */
    public int lengthOfLongestSubstring2(String s) {
        /*
         * 这个解法和上面的基本想法一样，只不过这里考虑的是长度，而不是推动的位置
         */
        if (s.length() < 2) {
            return s.length();
        }
        char[] str = s.toCharArray();
        int[] map = new int[256];
        // 表示之前的长度，一开始为 0，同时也充当当前的长度
        int pre = 0, len = 0;
        Arrays.fill(map, -1);
        for (int i = 0; i < str.length; ++i) {
            pre = Math.min(pre + 1, i - map[str[i]]);
            len = Math.max(len, pre);
            map[str[i]] = i;
        }
        return len;
    }
}

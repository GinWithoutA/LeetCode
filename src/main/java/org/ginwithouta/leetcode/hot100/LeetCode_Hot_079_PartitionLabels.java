package org.ginwithouta.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/2/29
 * LeetCode Hot 100 划分字母区间
 */
public class LeetCode_Hot_079_PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        /*
         * 整体的思路就是记录每一个位置的字符最后出现的位置。接着我们遍历每个字符，不断往右边
         * 延伸当前的最远距离。如果遍历到的位置等于最远距离，说明前面的字符只在这个最远距离内
         * 部出现过，后续都没有出现，因此就找到了一个划分
         */
        int[] map = new int[26];
        char[] strs = s.toCharArray();
        for (int i = 0; i < strs.length; ++i) {
            map[strs[i] - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < strs.length; ++i) {
            end = Math.max(end, map[strs[i] - 'a']);
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}

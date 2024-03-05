package org.ginwithouta.leetcode.normal;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2023/12/5
 * Problem H指数
 */
public class Problem_0274_HIndex {
    /**
     * H 指数指的是高引用次数，指的是发表的 h 篇论文每篇都至少被引用了 h 次，返回最大的 h
     */
    public int hIndex(int[] citations) {
        /*
         * 根据题意，我们需要找到最多篇数引用次数最高的 h 值，那我们首先可以想到的就是排序
         * 接着，从后面往前遍历，只要有一篇论文的引用次数高于现在的 h ，就说明我们找到了一
         * 个 h ，就令他 ++ ，直到不存在这样的论文，就是我们要的答案
         */
        Arrays.sort(citations);
        int res = 0, index = citations.length - 1;
        while (index >= 0 && citations[index] > res) {
            ++res;
            --index;
        }
        return res;
    }
}

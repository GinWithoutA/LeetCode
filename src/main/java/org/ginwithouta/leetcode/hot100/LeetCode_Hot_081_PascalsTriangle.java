package org.ginwithouta.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/3/1
 * LeetCode Hot 100 杨辉三角
 */
public class LeetCode_Hot_081_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> res = new ArrayList<>();
            res.add(1);
            if (i != 0) {
                for (int j = 1; j < i; ++j) {
                    res.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
                res.add(1);
            }
            ans.add(res);
        }
        return ans;
    }
}

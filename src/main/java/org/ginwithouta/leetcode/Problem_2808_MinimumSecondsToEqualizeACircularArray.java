package org.ginwithouta.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/1/30
 * Problem 使循环数组所有元素相等的最少秒数
 */
public class Problem_2808_MinimumSecondsToEqualizeACircularArray {
    public int minimumSeconds(List<Integer> nums) {
        /*
         * 每个元素都会变成相邻的元素，若要将所有元素变成相同的值，可以将这个过程想象成某个元素不断进行两侧
         * 感染的过程。这个过程需要的步骤的数量就是两个相邻元素的距离 / 2；因此我们遍历每个元素，记录相同元
         * 素的位置，遍历每个相邻元素，找到感染所需的时间最小值就可以
         */
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); ++i) {
            map.computeIfAbsent(nums.get(i), key -> new ArrayList<>()).add(i);
        }
        int ans = nums.size();
        for (ArrayList<Integer> idx : map.values()) {
            int disMax = idx.get(0) + nums.size() - idx.get(idx.size() - 1);
            for (int i = 1; i < idx.size(); ++i) {
                disMax = Math.max(disMax, idx.get(i) - idx.get(i - 1));
            }
            ans = Math.min(ans, disMax / 2);
        }
        return ans;
    }
}

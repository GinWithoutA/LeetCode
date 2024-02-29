package org.ginwithouta.leetcode.hot100;

import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author Ginwithouta
 * Generate at 2024/2/29
 * LeetCode Hot 100 前 K 个高频元素
 */
public class LeetCode_Hot_075_TopKFrequentElements {
    public static class Info {
        int val;
        int count;
        public Info(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) {
            return new int[] {nums[0]};
        }
        PriorityQueue<Info> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.count, o1.count));
        HashMap<Integer, Info> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.get(num).count++;
            } else {
                map.put(num, new Info(num, 1));
            }
        }
        for (Info info : map.values()) {
            heap.offer(info);
        }
        int[] ans = new int[k];
        while (k-- != 0) {
            ans[k] = Objects.requireNonNull(heap.poll()).val;
        }
        return ans;
    }
}

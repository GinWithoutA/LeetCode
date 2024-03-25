package org.ginwithouta.leetcode.spring100;

import java.util.*;

/**
 * @author Ginwithouta
 * Generate at 2024/3/25
 * LeetCode 春招 100 查找和最小的 K 对数字
 */
public class LeetCode_Spring_015_FindKPairsWithSmallestSums {
     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
         /*
          * 假设nums1是a,nums2是b，和最小的数对一开始肯定是a[]+b[0]，那么下一个就可能是a[1]+b[0]或者a[0]+b[1]
          * 因此，每次获取完一个当前的最小数对，就要把下一个可能的最小数对加到堆中。
          * 但此时可能会有一个问题，对于最小数对a[i]+b[j]，上一个可能是a[i-1]+b[j]==a[i]+b[j-1]，因此此时可能
          * 在堆中会存在两个a[i]+b[j]，为了不让这种情况出现，我们可以假设只有a[i]+b[j-1]是最小数对的时候才添加
          * a[i]+b[j]，否则不添加。
          * 因此，在初始化堆的过程中，我们需要a中元素为第一位的所有数对添加到堆中，保证后续不会只出现a[0]+b[j]
          * 的情况
          */
         PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
         List<List<Integer>> ans = new ArrayList<>();
         for (int i = 0; i < Math.min(nums1.length, k); ++i) {
             heap.offer(new int[] {nums1[i] + nums2[0], i, 0});
         }
         while (k-- != 0 && !heap.isEmpty()) {
             List<Integer> item = new ArrayList<>();
             int[] top = heap.poll();
             item.add(nums1[top[1]]);
             item.add(nums2[top[2]]);
             ans.add(item);
             if (top[2] + 1 < nums2.length) {
                heap.offer(new int[] {nums1[top[1]] + nums2[top[2] + 1], top[1], top[2] + 1});
             }
         }
         return ans;
     }
}

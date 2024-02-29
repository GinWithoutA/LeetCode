package org.ginwithouta.leetcode.hot100;

import java.util.PriorityQueue;

/**
 * @author Ginwithouta
 * Generate at 2024/2/29
 * leetCode Hot 100 数据流的中位数
 */
public class LeetCode_Hot_076_FindMedianFromDataStream {
    public static class MedianFinder {
        /*
         * 用两个堆，一个堆用来存小于等于中位数的数，另一堆用来存大于中位数的数
         * 当小于的堆为空，或者加入的num小于等于当前中位数，添加进去，并及时修改两个堆的数量关系
         * 若添加的数大于当前中位数，添加到大堆中，并及时修改两个堆的数量关系
         */
        public PriorityQueue<Integer> minHeap;
        public PriorityQueue<Integer> maxHeap;
        public MedianFinder() {
            this.minHeap = new PriorityQueue<>((a, b) -> (b - a));
            this.maxHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (minHeap.isEmpty() || num <= minHeap.peek()) {
                minHeap.offer(num);
                if (maxHeap.size() + 1 < minHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                }
            } else {
                maxHeap.offer(num);
                if (minHeap.size() + 1 == maxHeap.size()) {
                    minHeap.offer(maxHeap.poll());
                }
            }
        }

        public double findMedian() {
            if (((maxHeap.size() + minHeap.size()) & 1) == 1) {
                return minHeap.peek();
            } else {
                return (double) (minHeap.peek() + maxHeap.peek()) / 2;
            }
        }
    }
}

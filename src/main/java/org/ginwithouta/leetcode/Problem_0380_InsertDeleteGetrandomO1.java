package org.ginwithouta.leetcode;

import java.util.*;

/**
 * @author Ginwithouta
 * Generate at 2023/12/5
 * Problem O(1) 时间插入、删除和获取随机元素
 */
public class Problem_0380_InsertDeleteGetrandomO1 {

    public static class RandomizedSet {
        /*
         * 首先我们需要判断指定数是否存在，就需要哈希表帮忙，哈希表能在 O(1) 时间内找到我们想要的数，
         * 同时要满足随机访问，就需要一个数组实现，哈希表是无法根据下标进行随机访问的，因此整体结构
         * 就是一个哈希表加一个变长数组
         *
         * 哈希表存储数据在数组中的位置，然后数组实现随机获取
         */
        private List<Integer> nums;
        private Map<Integer, Integer> indexes;

        public RandomizedSet() {
            this.nums = new ArrayList<>();
            this.indexes = new HashMap<>();
        }

        public boolean insert(int val) {
            if (this.indexes.containsKey(val)) {
                return false;
            }
            nums.add(val);
            this.indexes.put(val, this.nums.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!this.indexes.containsKey(val)) {
                return false;
            }
            int lastNum = this.nums.get(this.nums.size() - 1), valIndex = this.indexes.get(val);
            this.nums.set(valIndex, lastNum);
            this.indexes.put(lastNum, valIndex);
            this.nums.remove(this.nums.size() - 1);
            this.indexes.remove(val);
            return true;
        }

        public int getRandom() {
            return this.nums.get((int) (Math.random() * this.nums.size()));
        }
    }

}

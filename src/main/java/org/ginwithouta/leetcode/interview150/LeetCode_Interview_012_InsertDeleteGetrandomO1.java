package org.ginwithouta.leetcode.interview150;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author Ginwithouta
 * Generate at 2024/3/28
 * LeetCode 面试经典 150 O(1) 时间插入、删除和获取随机元素
 */
public class LeetCode_Interview_012_InsertDeleteGetrandomO1 {
    public static class RandomizedSet {
        public HashMap<Integer, Integer> idxes;
        public List<Integer> list;
        public Random random;

        public RandomizedSet() {
            this.idxes = new HashMap<>();
            this.list = new ArrayList<>();
            this.random = new Random();
        }

        public boolean insert(int val) {
            if (this.idxes.containsKey(val)) {
                return false;
            }
            this.list.add(val);
            this.idxes.put(val, this.list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!this.idxes.containsKey(val)) {
                return false;
            }
            int idx = this.idxes.get(val), last = this.list.get(this.list.size() - 1);
            this.list.set(idx, last);
            this.idxes.put(last, idx);
            this.list.remove(this.list.size() - 1);
            this.idxes.remove(val);
            return true;
        }

        public int getRandom() {
            return this.list.get(this.random.nextInt(this.list.size()));
        }
    }
}

package org.ginwithouta.leetcode.hot100;

import lombok.val;
import org.ginwithouta.leetcode.common.tree.TreeNode;

import java.util.HashMap;

/**
 * @author Ginwithouta
 * Generate at 2024/2/22
 * LeetCode Hot 100 路径总和Ⅲ
 */
public class LeetCode_Hot_048_PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ans = rootSum(root, targetSum);
        ans += pathSum(root.left, targetSum);
        ans += pathSum(root.right, targetSum);
        return ans;
    }

    public int rootSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ans = root.val == targetSum ? 1 : 0;
        if ((long) targetSum - root.val < Integer.MIN_VALUE || (long) targetSum - root.val > Integer.MAX_VALUE) {
            return ans;
        }
        ans += rootSum(root.left, targetSum - root.val);
        ans += rootSum(root.right, targetSum - root.val);
        return ans;
    }

    public int pathSum2(TreeNode root, int targetSum) {
        /*
         * 和查找数字中和为 K 的子数字相同
         */
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return process(root, map, 0, targetSum);
    }

    public int process(TreeNode root, HashMap<Long, Integer> map, long preSum, int targetSum) {
        if (root == null) {
            return 0;
        }
        preSum += root.val;
        int ans = map.getOrDefault(preSum - targetSum, 0);
        map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        ans += process(root.left, map, preSum, targetSum);
        ans += process(root.right, map, preSum, targetSum);
        map.put(preSum, map.get(preSum) - 1);
        return ans;
    }

}

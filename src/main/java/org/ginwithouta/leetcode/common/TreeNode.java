package org.ginwithouta.leetcode.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * 二叉树节的点类
 */
@RequiredArgsConstructor
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;
}

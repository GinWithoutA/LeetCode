package org.ginwithouta.leetcode.common.trie;

/**
 * @author Ginwithouta
 * Generate at 2024/1/29
 */
public class TreeNode {
    public int end;
    public int pass;
    public TreeNode[] nexts;

    public TreeNode() {
        this.end = 0;
        this.pass = 0;
        this.nexts = new TreeNode[26];
    }
}

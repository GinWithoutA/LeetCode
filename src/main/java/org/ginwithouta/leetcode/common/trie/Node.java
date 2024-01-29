package org.ginwithouta.leetcode.common.trie;

/**
 * @author Ginwithouta
 * Generate at 2024/1/29
 * 前缀树节点类
 */
public class Node {
    public Node[] nexts;
    public boolean end;
    public Node() {
        this.nexts = new Node[26];
        this.end = false;
    }
}

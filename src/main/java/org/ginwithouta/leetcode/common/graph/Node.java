package org.ginwithouta.leetcode.common.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/1/29
 * 图的公共节点类
 */
public class Node {
    public int val;
    public List<Node> neighbors;
    public int in;
    public List<Node> nexts;
    public Node() {
        this.val = 0;
        this.neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        this.val = _val;
        this.neighbors = new ArrayList<>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        this.val = _val;
        this.neighbors = _neighbors;
    }
}

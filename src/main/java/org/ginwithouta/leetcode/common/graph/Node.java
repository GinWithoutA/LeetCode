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
        this.in = 0;
        this.val = 0;
        this.nexts = new ArrayList<>();
        this.neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        this.in = 0;
        this.val = _val;
        this.nexts = new ArrayList<>();
        this.neighbors = new ArrayList<>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        this.val = _val;
        this.neighbors = _neighbors;
    }
}

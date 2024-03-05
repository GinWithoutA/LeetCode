package org.ginwithouta.leetcode.normal;

import org.ginwithouta.leetcode.common.graph.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ginwithouta
 * Generate at 2024/1/29
 * Problem 克隆图
 */
public class Problem_0133_CloneGraph {
    public Map<Node, Node> visit = new HashMap<>();
    public Node cloneGraph(Node node) {
        /*
         * 图的深度优先遍历，为了防止重复访问某个图节点，我们需要一个 map 来告诉我们已经访问过了哪些节点
         * 如果已经访问过，则只需要将当前节点的克隆节点返回添加到原先节点的列表中就行
         */
        if (node == null) return null;
        if (visit.containsKey(node)) return visit.get(node);
        Node cloneNode = new Node(node.val);
        visit.put(node, cloneNode);
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}

package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2024/2/1
 * Problem 建立四叉树
 */
public class Problem_0427_ConstructQuadTree {
    public static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
    public Node construct(int[][] grid) {
        return process(grid, 0, grid.length - 1, 0, grid.length - 1);
    }
    public Node process(int[][] grid, int rowLeft, int rowRight, int colLeft, int colRight) {
        if (rowLeft > rowRight || colLeft > colRight) {
            return null;
        }
        boolean isSame = true;
        for (int i = rowLeft; i <= rowRight; ++i) {
            for (int j = colLeft; j <= colRight; ++j) {
                if (grid[i][j] != grid[rowLeft][colLeft]) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) {
                break;
            }
        }
        if (isSame) {
            return new Node(grid[rowLeft][colLeft] == 1, true);
        }
        int rowMid = (rowLeft + rowRight) / 2, colMid = (colLeft + colRight) / 2;
        return new Node(true, false,
                process(grid, rowLeft, rowMid, colLeft, colMid),
                process(grid, rowLeft, rowMid, colMid + 1, colRight),
                process(grid, rowMid + 1, rowRight, colLeft, colMid),
                process(grid, rowMid + 1, rowRight, colMid + 1, colRight));
    }
}

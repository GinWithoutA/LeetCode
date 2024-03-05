package org.ginwithouta.leetcode.normal;

/**
 * @author Ginwithouta
 * Generate at 2024/1/27
 * Problem 岛屿数量（优化的并查集版本）
 */
public class Problem_0200_NumberOfIslands_UnionSet_better {
    public static class UnionSetArray {
        public int[] sizes;
        public int[] parents;
        public int[] stack;
        public int col;
        public int sets;

        public int getIndex(int row, int col) {
            return row * this.col + col;
        }

        public UnionSetArray(char[][] grid) {
            this.col = grid[0].length;
            this.sets = 0;
            int length = grid.length * grid[0].length;
            this.sizes = new int[length];
            this.parents = new int[length];
            this.stack = new int[length];
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    if (grid[i][j] == '1') {
                        int index = this.getIndex(i, j);
                        this.parents[index] = index;
                        this.sizes[index] = 1;
                        ++this.sets;
                    }
                }
            }
        }

        public int find(int index) {
            int top = 0;
            while (index != this.parents[index]) {
                stack[top++] = index;
                index = this.parents[index];
            }
            while (top != 0) {
                this.parents[this.stack[--top]] = index;
            }
            return index;
        }

        public void union(int left, int right) {
            int leftParent = this.find(left), rightParent = this.find(right);
            if (leftParent != rightParent) {
                if (this.sizes[leftParent] > this.sizes[rightParent]) {
                    this.parents[rightParent] = leftParent;
                    this.sizes[leftParent] += this.sizes[rightParent];
                } else {
                    this.parents[leftParent] = rightParent;
                    this.sizes[rightParent] += this.sizes[leftParent];
                }
                --this.sets;
            }
        }
    }

    public int numIslands(char[][] grid) {
        UnionSetArray set = new UnionSetArray(grid);
        for (int i = 1; i < grid[0].length; ++i) {
            if (grid[0][i] == '1' && grid[0][i - 1] == '1') {
                set.union(set.getIndex(0, i), set.getIndex(0, i - 1));
            }
        }
        for (int i = 1; i < grid.length; ++i) {
            if (grid[i][0] == '1' && grid[i - 1][0] == '1') {
                set.union(set.getIndex(i, 0), set.getIndex(i - 1, 0));
            }
        }
        for (int i = 1; i < grid.length; ++i) {
            for (int j = 1; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    if (grid[i][j - 1] == '1') {
                        set.union(set.getIndex(i, j), set.getIndex(i, j - 1));
                    }
                    if (grid[i - 1][j] == '1') {
                        set.union(set.getIndex(i, j), set.getIndex(i - 1, j));
                    }
                }
            }
        }
        return set.sets;
    }
}

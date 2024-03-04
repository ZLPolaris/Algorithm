package com.learn.LC200;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionOne {
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int row, int column) {
        Deque<int[]> deque = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        deque.offer(new int[]{row, column});
        grid[row][column] = '0';
        while (!deque.isEmpty()) {
            int[] peek = deque.poll();
            int i = peek[0], j = peek[1];
            if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                grid[i - 1][j] = '0';
                deque.offer(new int[]{i - 1, j});
            }
            if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                grid[i][j - 1] = '0';
                deque.offer(new int[]{i, j - 1});
            }
            if (i + 1 < m && grid[i + 1][j] == '1') {
                grid[i + 1][j] = '0';
                deque.offer(new int[]{i + 1, j});
            }
            if (j + 1 < n && grid[i][j + 1] == '1') {
                grid[i][j + 1] = '0';
                deque.offer(new int[]{i, j + 1});
            }
        }
    }
}

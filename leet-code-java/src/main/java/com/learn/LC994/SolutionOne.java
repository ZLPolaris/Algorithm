package com.learn.LC994;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionOne {
    public int orangesRotting(int[][] grid) {
        int res = -1;
        Deque<int[]> deque = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        int freshNumber = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    deque.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshNumber++;
                }
            }
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] peek = deque.poll();
                int row = peek[0], column = peek[1];
                if (row - 1 >= 0 && grid[row - 1][column] == 1) {
                    grid[row - 1][column] = 2;
                    freshNumber--;
                    deque.offer(new int[]{row - 1, column});
                }
                if (column - 1 >= 0 && grid[row][column - 1] == 1) {
                    grid[row][column - 1] = 2;
                    freshNumber--;
                    deque.offer(new int[]{row, column - 1});
                }
                if (row + 1 < m && grid[row + 1][column] == 1) {
                    grid[row + 1][column] = 2;
                    freshNumber--;
                    deque.offer(new int[]{row + 1, column});
                }
                if (column + 1 < n && grid[row][column + 1] == 1) {
                    grid[row][column + 1] = 2;
                    freshNumber--;
                    deque.offer(new int[]{row, column + 1});
                }
            }
            if (!deque.isEmpty()) {
                res++;
            }
        }
        return freshNumber == 0 ? res : -1;
    }
}

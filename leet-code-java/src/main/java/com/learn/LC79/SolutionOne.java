package com.learn.LC79;

import javax.swing.*;

public class SolutionOne {
    private Integer m;
    private Integer n;
    private Integer wordLength = 0;
    private int[][] data = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int[][] colors;

    public boolean exist(char[][] board, String word) {
        this.wordLength = word.length();
        this.m = board.length;
        this.n = board[0].length;
        colors = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && this.isExist(board, word, i, j, 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isExist(char[][] board, String word, int row, int column, int index) {
        if (index >= wordLength) {
            return true;
        }
        colors[row][column] = 1;
        for (int[] select : data) {
            int iRow = select[0] + row;
            int iColumn = select[1] + column;
            if (0 <= iRow && iRow < m && 0 <= iColumn && iColumn < n && colors[iRow][iColumn] == 0 && board[iRow][iColumn] == word.charAt(index)) {
                if (this.isExist(board, word, iRow, iColumn, index + 1)) {
                    return true;
                }
            }
        }
        colors[row][column] = 0;
        return false;
    }
}

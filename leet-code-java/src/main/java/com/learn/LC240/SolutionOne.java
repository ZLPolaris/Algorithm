package com.learn.LC240;

public class SolutionOne {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        return this.searchNMatrix(matrix, target, 0, m - 1, 0, n - 1);
    }

    private boolean searchNMatrix(int[][] matrix, int target, int rowS, int rowE, int columnS, int columnE) {
        int armLength = Math.min(rowE - rowS, columnE - columnS) + 1;
        int left = 0;
        int right = armLength - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (matrix[rowS + mid][columnS + mid] == target) {
                return true;
            } else if (matrix[rowS + mid][columnS + mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < armLength) {
            for (int i = left + columnS - 1; i >= columnS; i--) {
                if (matrix[left + rowS][i] == target) {
                    return true;
                }
            }
            for (int i = left + rowS - 1; i >= rowS; i--) {
                if (matrix[i][left + columnS] == target) {
                    return true;
                }
            }
        } else {
            if (rowE - rowS > columnE - columnS) {
                return this.searchNMatrix(matrix, target, rowS + armLength, rowE, columnS, columnE);
            } else if (rowE - rowS < columnE - columnS) {
                return this.searchNMatrix(matrix, target, rowS, rowE, columnS + armLength, columnE);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().searchMatrix(new int[][]{
                {-1, 3}
        }, 3));
    }
}

package com.learn.LC240;

public class SolutionTwo {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length - 1;
        int pointX = m - 1;
        int pointY = 0;
        while (0 <= pointX && pointX < m && 0 <= pointY && pointY < n) {
            if (matrix[pointX][pointY] == target) {
                return true;
            } else if (matrix[pointX][pointY] > target) {
                pointX -= 1;
            } else {
                pointY -= 1;
            }
        }
        return false;
    }
}

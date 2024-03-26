package com.learn.LC74;

public class SolutionOne {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = -1;
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] > target) {
                row = i;
                break;
            } else if (matrix[i][n - 1] == target) {
                return true;
            }
        }
        if (row == -1) {
            return false;
        }
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

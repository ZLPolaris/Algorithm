package com.learn.LC62;

public class SolutionOne {
    public int uniquePaths(int m, int n) {
        int k = Math.min(m - 1, n - 1);
        int p = m + n - 2;
        long multiplyOne = 1;
        for (int x = 1, y = 1 + p - k; x <= k; x++,y++) {
            multiplyOne = multiplyOne * y / x;
        }
        return (int) multiplyOne;
    }
}

package com.learn.LC132;

public class SolutionTwo {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = true;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][j + i] = s.charAt(j) == s.charAt(j + i) && dp[j + 1][j + i - 1];
            }
        }
        int[] res = new int[n];
        for (int i = 1; i < n; i++) {
            if (dp[0][i]) {
                res[i] = 0;
            } else {
                res[i] = Integer.MAX_VALUE;
                for (int j = i; j >= 1; j--) {
                    if (dp[j][i]) {
                        res[i] = Math.min(res[i], res[j - 1] + 1);
                    }
                }
            }
        }
        return res[n - 1];
    }
}

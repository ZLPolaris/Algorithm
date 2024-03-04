package com.learn.LC279;

public class SolutionOne {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j <= Math.sqrt(n) ; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j]) + 1;
            }
        }
        return dp[n];
    }
}

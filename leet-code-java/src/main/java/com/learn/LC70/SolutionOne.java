package com.learn.LC70;

public class SolutionOne {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[1] + dp[0];
        }
        return dp[n];
    }
}

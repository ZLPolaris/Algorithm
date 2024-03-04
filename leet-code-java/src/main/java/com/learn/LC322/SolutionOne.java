package com.learn.LC322;

public class SolutionOne {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != -1) {
                    if (dp[i] == -1) {
                        dp[i] = dp[i - coin] + 1;
                    } else {
                        dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                    }
                }
            }
        }
        return dp[amount];
    }
}

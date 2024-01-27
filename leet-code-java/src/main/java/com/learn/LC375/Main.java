package com.learn.LC375;

class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];

        // i代表列
        for (int i = 2; i <= n; i++) {
            // j代表行
            for (int j = i - 1; j >= 1; j--) {
                dp[j][i] = j + dp[j + 1][i];
                for (int k = j + 1; k <= i - 1; k++) {
                    dp[j][i] = Math.min(dp[j][i], Math.max(dp[j][k - 1], dp[k + 1][i]) + k);
                }
                dp[j][i] = Math.min(dp[j][i], dp[j][i - 1] + i);
            }
        }

        return dp[1][n];
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().getMoneyAmount(10));
    }
}

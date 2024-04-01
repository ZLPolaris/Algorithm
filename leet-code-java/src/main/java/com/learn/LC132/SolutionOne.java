package com.learn.LC132;

import java.util.Arrays;

// 复杂度过高
public class SolutionOne {
    public int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (s.charAt(j) == s.charAt(j + i) && dp[j + 1][j + i - 1] == 0) {
                    continue;
                }
                dp[j][j + i] = Integer.MAX_VALUE;
                for (int k = j; k <= j + i - 1; k++) {
                    dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k + 1][j + i]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][n - 1];
    }
}

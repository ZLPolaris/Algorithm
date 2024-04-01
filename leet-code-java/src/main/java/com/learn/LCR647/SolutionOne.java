package com.learn.LCR647;

public class SolutionOne {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = n;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = true;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][j + i] = s.charAt(j) == s.charAt(j + i) && dp[j + 1][j + i - 1];
                if(dp[j][j + i]){
                    count++;
                }
            }
        }
        return count;
    }
}

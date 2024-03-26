package com.learn.LC5;

public class SolutionOne {
    public String longestPalindrome(String s) {
        int sLength = s.length();
        boolean[][] dp = new boolean[sLength][sLength];
        String res = String.valueOf(s.charAt(0));
        for (int i = 0; i < sLength; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = true;
            }
        }
        for (int i = 1; i < sLength; i++) {
            for (int j = 0; j < sLength - i; j++) {
                dp[j][j + i] = s.charAt(j) == s.charAt(j + i) && dp[j + 1][j + i - 1];
                if (dp[j][j + i] && i + 1 > res.length()) {
                    res = s.substring(j, j + i + 1);

                }
            }
        }
        return res;
    }
}

package com.learn.LC376;

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j][1] + 1 > dp[i][0]) {
                    dp[i][0] = dp[j][1] + 1;
                }
                if (nums[i] < nums[j] && dp[j][0] + 1 > dp[i][1]) {
                    dp[i][1] = dp[j][0] + 1;
                }
                max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
            }
        }
        return max;
    }
}


public class Main {
    public static void main(String[] args) {

    }
}
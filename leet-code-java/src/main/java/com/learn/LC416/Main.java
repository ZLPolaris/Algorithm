package com.learn.LC416;

import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) {
            return false;
        }
        int n = nums.length;
        int halfSum = sum / 2;
        boolean[][] dp = new boolean[n][halfSum + 1];
        for (int i = 1; i <= halfSum; i++) {
            dp[0][i] = nums[0] == i;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= halfSum; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][halfSum];
    }
}

public class Main {
    public static void main(String[] args) {

    }
}

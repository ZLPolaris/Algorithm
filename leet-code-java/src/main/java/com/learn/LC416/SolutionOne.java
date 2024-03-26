package com.learn.LC416;

public class SolutionOne {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int numsLength = nums.length;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        boolean[][] dp = new boolean[numsLength][target + 1];
        dp[0][0] = true;
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < numsLength; i++) {
            dp[i][0] = true;
            for (int j = 1; j <= target; j++) {
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            if (dp[i][target]) {
                return true;
            }
        }
        return false;
    }
}

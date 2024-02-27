package com.learn.LC53;

public class SolutionOne {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int numsLength = nums.length;
        int[] dp = new int[numsLength];
        dp[0] = nums[0];
        for (int i = 1; i < numsLength; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}

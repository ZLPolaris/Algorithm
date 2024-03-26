package com.learn.LC300;

public class SolutionOne {
    public int lengthOfLIS(int[] nums) {
        int numsLength = nums.length;
        int[] dp = new int[numsLength];
        dp[0] = 1;
        int biggest = 1;
        for (int i = 1; i < numsLength; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            biggest = Math.max(biggest, dp[i]);
        }
        return biggest;
    }
}

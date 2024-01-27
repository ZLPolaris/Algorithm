package com.learn.LC377;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[]  dp =  new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            dp[i] = 0;
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}

public class Main {
}

package com.learn.LC55;

public class SolutionTwo {
    public boolean canJump(int[] nums) {
        int rightMost = 0;
        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, nums[i] + i);
                if (rightMost >= numsLength - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}

package com.learn.LC268;

public class SolutionTwo {
    public int missingNumber(int[] nums) {
        int xor = 0;
        int n = nums.length;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        return xor;
    }
}

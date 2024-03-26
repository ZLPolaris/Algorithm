package com.learn.LC268;

// 利用数组哈希
public class SolutionOne {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int key;
            if (nums[i] >= 0) {
                key = nums[i];
            } else {
                key = Math.abs(nums[i]) - 1;
            }
            if (key < n) {
                nums[key] = -nums[key] - 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i;
            }
        }
        return n;
    }
}

package com.learn.LC41;

import java.util.Arrays;

public class SolutionOne {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (Math.abs(nums[i]) < n + 1) {
                int key = Math.abs(nums[i]) - 1;
                nums[key] = -Math.abs(nums[key]);
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().firstMissingPositive(new int[]{3,4,-1,1}));
    }
}

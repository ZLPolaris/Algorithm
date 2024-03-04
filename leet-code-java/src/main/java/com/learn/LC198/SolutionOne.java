package com.learn.LC198;

import org.jetbrains.annotations.NotNull;

public class SolutionOne {
    public int rob(@NotNull int[] nums) {
        int first = 0;
        int second = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = first;
            first = second;
            second = Math.max(tmp + nums[i], second);
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().rob(new int[]{1, 2, 3, 1}));
    }
}

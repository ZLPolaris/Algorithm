package com.learn.LCR238;

import java.util.Arrays;

public class SolutionOne {
    public int[] productExceptSelf(int[] nums) {
        int numsLength = nums.length;
        int[] answer = new int[numsLength];
        answer[0] = 1;
        for (int i = 1; i < numsLength; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int i = numsLength - 1; i >= 0; i--) {
            answer[i] = answer[i] * r;
            r = r * nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SolutionOne().productExceptSelf(new int[]{1, 2, 3, 4})));
    }

}

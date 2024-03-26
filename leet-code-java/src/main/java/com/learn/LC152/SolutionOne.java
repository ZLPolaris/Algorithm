package com.learn.LC152;

public class SolutionOne {
    public int maxProduct(int[] nums) {
        int numsLength = nums.length;
        int[] dpMax = new int[numsLength];
        int[] dpMin = new int[numsLength];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int biggest = nums[0];
        for (int i = 1; i < numsLength; i++) {
            if (nums[i] == 0) {
                dpMin[i] = 0;
                dpMax[i] = 0;
            } else if (nums[i] > 0) {
                dpMax[i] = Math.max(nums[i], dpMax[i - 1] * nums[i]);
                dpMin[i] = Math.min(nums[i], dpMin[i - 1] * nums[i]);
            } else {
                dpMax[i] = Math.max(nums[i], dpMin[i - 1] * nums[i]);
                dpMin[i] = Math.min(nums[i], dpMax[i - 1] * nums[i]);
            }
            if(dpMax[i] > biggest){
                biggest = dpMax[i];
            }
        }
        return biggest;
    }
}

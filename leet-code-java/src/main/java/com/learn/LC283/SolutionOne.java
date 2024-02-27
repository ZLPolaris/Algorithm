package com.learn.LC283;

public class SolutionOne {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        int numLength = nums.length;
        while (right < numLength) {
            while (right < numLength && nums[right] == 0) {
                right++;
            }
            if (right >= numLength) {
                break;
            }
            nums[left] = nums[right];
            left++;
            right++;
        }
        while (left < numLength) {
            nums[left] = 0;
            left++;
        }
    }
}

package com.learn.LC1;

import java.util.Arrays;

public class SolutionTwo {
    public int[] twoSum(int[] nums, int target) {
        int numLength = nums.length;
        Integer[] numIndex = new Integer[numLength];
        for (int i = 0; i < numLength; i++) {
            numIndex[i] = i;
        }
        Arrays.sort(numIndex, (o1, o2) -> nums[o1] - nums[o2]);
        int left = 0, right = numLength - 1;
        while (left < right) {
            if (nums[numIndex[left]] + nums[numIndex[right]] == target) {
                return new int[]{numIndex[left],numIndex[right]};
            } else if (nums[numIndex[left]] + nums[numIndex[right]] < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}

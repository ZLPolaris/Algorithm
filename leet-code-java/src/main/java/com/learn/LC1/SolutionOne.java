package com.learn.LC1;

import java.util.HashMap;

public class SolutionOne {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> data = new HashMap<>();
        int numLength = nums.length;
        for (int i = 0; i < numLength; i++) {
            if (data.containsKey(target - nums[i])) {
                return new int[]{data.get(target - nums[i]), i};
            }
            data.put(nums[i], i);
        }
        return null;
    }
}

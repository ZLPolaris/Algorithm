package com.learn.LC560;

import java.util.HashMap;

public class SolutionTwo {
    public int subarraySum(int[] nums, int k) {
        int numLength = nums.length;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int preSumCount = 0;
        int res = 0;
        for (int i = 0; i < numLength; i++) {
            preSumCount += nums[i];
            res += preSum.getOrDefault(preSumCount - k, 0);
            preSum.put(preSumCount, preSum.getOrDefault(preSumCount, 0) + 1);
        }
        return res;
    }
}

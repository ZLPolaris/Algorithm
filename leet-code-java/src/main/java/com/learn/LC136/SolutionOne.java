package com.learn.LC136;

public class SolutionOne {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums){
            res ^= num;
        }
        return res;
    }

}

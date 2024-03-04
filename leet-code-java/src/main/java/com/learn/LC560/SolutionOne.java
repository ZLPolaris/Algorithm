package com.learn.LC560;

public class SolutionOne {
    public int subarraySum(int[] nums, int k) {
        int numsLength = nums.length;
        int[] sum = new int[numsLength];
        int sumCount = 0;
        int res = 0;
        for (int i = 0; i < numsLength; i++) {
            sumCount += nums[i];
            sum[i] = sumCount;
            if (sumCount == k) {
                res++;
            }
        }
        for (int i = 1; i < numsLength; i++) {
            for (int j = i; j < numsLength; j++) {
                sum[j] -= nums[i - 1];
                if(sum[j] == k){
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().subarraySum(new int[]{1, 2, 3}, 3));
    }
}

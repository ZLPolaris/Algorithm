package com.learn.LC209;

public class SolutionOne {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = left;
        int sum = nums[0];
        int res = Integer.MAX_VALUE;
        while (left < n) {
            while (right < n - 1 && sum < target) {
                sum += nums[++right];
            }
            if (sum >= target) {
                res = Math.min(res, right - left + 1);
            } else {
                break;
            }
            sum -= nums[left++];
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().minSubArrayLen(4, new int[]{1, 4, 4}));
    }
}

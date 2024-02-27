package com.learn.LC53;

public class SolutionTwo {
    public int maxSubArray(int[] nums) {
        return this.getMaxSubArray(nums, 0, nums.length - 1);
    }

    private int getMaxSubArray(int[] nums, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        int mid = (left + right) >> 1;
        int leftMax = this.getMaxSubArray(nums, left, mid);
        int rightMax = this.getMaxSubArray(nums, mid + 1, right);
        int rightAddMax = nums[mid + 1];
        int rightAdd = nums[mid + 1];
        for (int i = mid + 2; i <= right; i++) {
            rightAdd += nums[i];
            rightAddMax = Math.max(rightAdd, rightAddMax);
        }
        int leftAddMax = nums[mid];
        int leftAdd = nums[mid];
        for (int i = mid - 1; i >= left; i--) {
            leftAdd += nums[i];
            leftAddMax = Math.max(leftAdd, leftAddMax);
        }
        int midMax = leftAddMax + rightAddMax;
        return Math.max(midMax, Math.max(leftMax, rightMax));
    }

    public static void main(String[] args) {
        System.out.println((2 + 3) >> 1);
    }
}

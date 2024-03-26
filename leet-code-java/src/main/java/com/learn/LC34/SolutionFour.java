package com.learn.LC34;

public class SolutionFour {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = getLeft(nums, target);
        res[1] = getRight(nums, target);
        if(res[0] > res[1]){
            res[0] = res[1] = -1;
        }
        return res;
    }

    private int getLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}

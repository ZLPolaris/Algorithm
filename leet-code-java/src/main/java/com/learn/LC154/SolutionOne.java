package com.learn.LC154;

public class SolutionOne {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > right) {
                left = mid + 1;
            } else {
                if (nums[mid] > nums[left]) {
                    return nums[left];
                } else if (nums[mid] < nums[left]) {
                    right = mid;
                } else {
                    left++;
                    right--;
                }
            }
        }
        return nums[left];
    }
}

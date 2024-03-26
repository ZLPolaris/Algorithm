package com.learn.LC81;

public class SolutionOne {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target || target == nums[left] || target == nums[right]) {
                return true;
            } else if (nums[left] < nums[mid] || nums[mid] > nums[right]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid] || nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left += 1;
                right -= 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().search(new int[]{1, 0, 1, 1, 1}, 0));
    }
}

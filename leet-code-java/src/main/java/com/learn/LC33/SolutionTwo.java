package com.learn.LC33;

public class SolutionTwo {
    public int search(int[] nums, int target) {
        int left = 0;  // 代表左侧元素没有target
        int right = nums.length - 1; // 代表右侧元素没有target
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) { // 左侧数组有序
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if(nums[mid] < target && target <= nums[right]){  // 右侧数组有序
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

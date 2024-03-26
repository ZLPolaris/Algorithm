package com.learn.LC540;

public class SolutionOne {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int leftLength = mid - left;
            if ((leftLength & 1) == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    left = mid + 2;
                } else {
                    if (nums[mid] != nums[mid - 1]) {
                        return nums[mid];
                    } else {
                        right = mid - 2;
                    }
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                }else {
                    if(nums[mid] != nums[mid + 1]){
                        return nums[mid];
                    }else {
                        right = mid - 1;
                    }
                }
            }
        }
        return nums[left];
    }
}

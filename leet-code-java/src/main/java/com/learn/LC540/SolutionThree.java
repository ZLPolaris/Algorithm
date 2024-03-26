package com.learn.LC540;

public class SolutionThree {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == nums[mid ^ 1]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return nums[left];
    }
}

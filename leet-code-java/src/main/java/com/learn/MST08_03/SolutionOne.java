package com.learn.MST08_03;

public class SolutionOne {
    public int findMagicIndex(int[] nums) {
        return findTheMagicIndex(nums,0, nums.length - 1);
    }

    private int findTheMagicIndex(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return nums[left] == left ? left : -1;
        }
        int mid = left + ((right - left) >> 1);
        if (nums[mid] == mid) {
            return findTheMagicIndex(nums, left, mid);
        } else if (nums[mid] >= nums.length) {
            return findTheMagicIndex(nums, left, mid - 1);
        } else if (nums[mid] < 0) {
            return findTheMagicIndex(nums, mid + 1, right);
        } else {
            int leftRes = findTheMagicIndex(nums, left, mid - 1);
            if (leftRes != -1) {
                return leftRes;
            } else {
                return findTheMagicIndex(nums, mid + 1, right);
            }
        }
    }

}

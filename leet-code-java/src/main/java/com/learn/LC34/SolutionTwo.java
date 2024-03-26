package com.learn.LC34;

public class SolutionTwo {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = this.getLeft(nums, target);
        res[1] = this.getRight(nums, target);
        if (res[0] > res[1]) {
            res[0] = res[1] = -1;
        }
        return res;
    }

    // 求刚好大于等于target的元素位置
    private int getLeft(int[] nums, int target) {
        int left = 0;   // 左边元素都比target小
        int right = nums.length; // 右边元素包含自身都大于等于target
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 求刚好小于等于target元素的位置 -1 ~ n - 1
    private int getRight(int[] nums, int target) {
        int left = -1; // 左边包含本身元素都小于target（或者从-1是取值范围理解）
        int right = nums.length - 1; // 右边的元素都大于target
        while (left < right) {
            int mid = right - ((right - left) >> 1);
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}

package com.learn.LC34;

public class SolutionThree {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = this.getLeft(nums,target) + 1;
        res[1] = this.getRight(nums, target) - 1;
          if (res[0] > res[1]) {
            res[0] = res[1] = -1;
        }
        return res;
    }

    // 求刚好小于target的元素位置
    private int getLeft(int[] nums, int target) {
        int left = -1;   // 左边元素包含自身都小于target
        int right = nums.length - 1; // 右边元素不包含本身都大于等于target
        while (left < right) {
            int mid = right - ((right - left) >> 1);
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    // 求刚好大于这个元素的位置
    private int getRight(int[] nums, int target) {
        int left = 0; // 左边元素不包含自身小于等于target
        int right = nums.length; //右边元素包含本身都大于target
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

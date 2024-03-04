package com.learn.LC189;

public class SolutionOne {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
            left++;
            right--;
        }
    }
}

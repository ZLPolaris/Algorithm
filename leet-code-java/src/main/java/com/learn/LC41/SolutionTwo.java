package com.learn.LC41;

import java.util.Arrays;

public class SolutionTwo {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 1 && nums[i] <= n && nums[i] != i + 1) {
                while (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, nums[i] - 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionTwo().firstMissingPositive(new int[]{1, 1}));
    }
}

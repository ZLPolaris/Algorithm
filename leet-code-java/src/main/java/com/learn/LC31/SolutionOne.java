package com.learn.LC31;

import java.util.Arrays;

public class SolutionOne {
    public void nextPermutation(int[] nums) {
        int pos = nums.length - 2;
        while (pos >= 0 && nums[pos] >= nums[pos + 1]) {
            pos--;
        }
        if (pos == -1) {
            this.reversed(nums, 0, nums.length - 1);
            return;
        }
        int right = nums.length - 1;
        while (nums[right] <= nums[pos]) {
            right--;
        }
        swap(nums, pos, right);
        reversed(nums, pos + 1, nums.length - 1);
    }

    private void reversed(int[] num, int left, int right) {
        while (left < right) {
            swap(num, left++, right--);
        }
    }

    private void swap(int[] nums, int one, int two) {
        int tmp = nums[one];
        nums[one] = nums[two];
        nums[two] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new SolutionOne().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

package com.learn.LC75;

import java.util.Arrays;

public class SolutionOne {
    public void sortColors(int[] nums) {
        int numsLength = nums.length;
        int zeroEnd = 0;
        int twoEnd = numsLength - 1;
        while (zeroEnd < nums.length && nums[zeroEnd] == 0) {
            zeroEnd++;
        }
        while (twoEnd >= 0 && nums[twoEnd] == 2) {
            twoEnd--;
        }
        int i = zeroEnd;
        while (i <= twoEnd) {
            if (nums[i] == 2) {
                swap(nums, i, twoEnd);
                twoEnd--;
            } else if (nums[i] == 1) {
                i++;
            } else {
                nums[i] = 1;
                nums[zeroEnd++] = 0;
                i++;
            }
        }
    }

    private void swap(int[] nums, int one, int two) {
        int tmp = nums[one];
        nums[one] = nums[two];
        nums[two] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        new SolutionOne().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

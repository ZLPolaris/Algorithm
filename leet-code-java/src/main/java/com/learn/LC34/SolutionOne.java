package com.learn.LC34;

import java.util.Arrays;

public class SolutionOne {

    // 定位到刚好大于等于的位置
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int n = nums.length;
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left >= n || nums[left] > target)
            return res;
        int k = left;
        while (k < n && nums[k] == target)
            k++;
        res[0] = left;
        res[1] = k - 1;
        return res;
    }

    // 定位到刚好 刚好小于等于的位置
    public void test(int[] nums, int target) {
        int left = -1;
        int right = nums.length - 1;
        while (left < right) {
            int mid = right - ((right - left) >> 1);
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }

    // 定位到刚好小于的位置
    public void test1(int[] nums, int target) {
        int left = -1;
        int right = nums.length - 1;
        while (left < right) {
            int mid = right - ((right - left) >> 1);
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        System.out.println(left);
    }

    // 定位到刚好大于的位置
    public void test2(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
    }

    public static void main(String[] args) {
        new SolutionOne().test2(new int[]{2, 3}, 3);
    }
}

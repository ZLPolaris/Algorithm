package com.learn.LC35;

public class SolutionOne {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            System.out.println(mid);
            if (nums[mid] == target) {
                System.out.println(nums[mid]);
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().searchInsert(new int[]{1, 3, 5}, 3));
    }

}

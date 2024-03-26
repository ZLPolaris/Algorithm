package com.learn.LC209;

import com.learn.LC81.SolutionOne;

// 思路不正确，合并策略错误，
public class SolutionTwo {
    public int minSubArrayLen(int target, int[] nums) {
        int res = this.getMinSubArrayLen(nums, target, 0, nums.length - 1);
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private int getMinSubArrayLen(int[] nums, int target, int left, int right) {
        if (left == right) {
            if (nums[left] >= target) {
                return 1;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        int mid = left + ((right - left) >> 1);
        int leftRes = this.getMinSubArrayLen(nums, target, left, mid);
        int rightRes = this.getMinSubArrayLen(nums, target, mid + 1, right);
        int leftEnd = mid - 1, rightEnd = mid + 2;
        int sum = nums[mid] + nums[mid + 1];
        while (sum < target && leftEnd >= left && rightEnd <= right) {
            if (nums[leftEnd] >= nums[rightEnd]) {
                sum += nums[leftEnd--];
            } else {
                sum += nums[rightEnd++];
            }
        }
        while (sum < target && leftEnd >= left) {
            sum += nums[leftEnd--];
        }
        while (sum < target && rightEnd <= right) {
            sum += nums[rightEnd++];
        }
        int mergeRes = Integer.MAX_VALUE;
        if (sum >= target) {
            mergeRes = rightEnd - leftEnd - 1;
        }
        System.out.println(nums[mid]);
        System.out.println(leftRes);
        System.out.println(rightRes);
        System.out.println(mergeRes);
        System.out.println("-----------");
        return Math.min(mergeRes, Math.min(leftRes, rightRes));
    }
    public static void main(String[] args) {
        System.out.println(new SolutionTwo().minSubArrayLen(213, new int[]{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12}));
    }
}

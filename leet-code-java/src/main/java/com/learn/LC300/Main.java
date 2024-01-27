package com.learn.LC300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
        }
        return max;
    }
}

class Solution1 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > res.get(res.size() - 1)) {
                res.add(nums[i]);
            } else {
                int index = Solution1.binarySearch(res, nums[i]);
                res.set(index, nums[i]);
            }
        }
        System.out.println(res);
        return res.size();
    }

    public static int binarySearch(List<Integer> res, int target) {
        int left = 0, right = res.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (res.get(mid) == target) {
                return mid;
            } else if (res.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}

package com.learn.LC209;

import java.util.Arrays;

public class SolutionThree {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int s = sum[i] + target;
            int searchKey = Arrays.binarySearch(sum, s);
            if (searchKey < 0) {
                searchKey = -searchKey - 1;
            }
            if (searchKey <= n) {
                res = Math.min(res, searchKey - i);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

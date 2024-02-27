package com.learn.LC15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 14:20
public class SolutionOne {
    public List<List<Integer>> threeSum(int[] nums) {
        int numLength = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numLength; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if(nums[i] > 0){
                return res;
            }
            int left = i + 1;
            int right = numLength - 1;
            while (left < right) {
                int value = nums[i] + nums[left] + nums[right];
                if (value == 0) {
                    res.add(new ArrayList<>(List.of(nums[i], nums[left], nums[right])));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (value < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}

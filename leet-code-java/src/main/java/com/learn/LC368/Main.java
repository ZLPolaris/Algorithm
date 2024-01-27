package com.learn.LC368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//class Solution {
//    public List<Integer> largestDivisibleSubset(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return new ArrayList<>();
//        }
//        int n = nums.length;
//        Arrays.sort(nums);
//
//        int[] dp = new int[n];
//        List<List<Integer>> lists = new ArrayList<>();
//        dp[0] = 1;
//        List<Integer> list = new ArrayList<>();
//        list.add(nums[0]);
//        lists.add(list);
//        int max = 1;
//        int max_index = 0;
//
//        for (int i = 1; i < n; i++) {
//            dp[i] = 1;
//            list = new ArrayList<>();
//            for (int j = i - 1; j >= 0; j--) {
//                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
//                    dp[i] = dp[j] + 1;
//                    list = new ArrayList<>(lists.get(j));
//                }
//            }
//            list.add(nums[i]);
//            lists.add(list);
//            if(dp[i] > max) {
//                max = dp[i];
//                max_index = i;
//            }
//        }
//        return lists.get(max_index);
//    }
//}

// 采用倒退解决
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int n = nums.length;
        Arrays.sort(nums);

        // 求出最大值和对应下标。
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        int max_index = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if(dp[i] > max) {
                max = dp[i];
                max_index = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = max_index; i >= 0 && max > 0; i--) {
            if(nums[max_index] % nums[i] == 0 && dp[i] == max){
                list.add(nums[i]);
                max_index = i;
                max--;
            }
        }
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(1 % 2);
    }
}

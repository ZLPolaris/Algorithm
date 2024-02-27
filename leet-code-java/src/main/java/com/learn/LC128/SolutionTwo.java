package com.learn.LC128;

import java.util.HashMap;

public class SolutionTwo {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                int left = hashMap.getOrDefault(num - 1, 0);
                int right = hashMap.getOrDefault(num + 1, 0);
                int length = left + right + 1;
                // 排除重复的num，实际计算区间用不到
                hashMap.put(num, 0);
                hashMap.put(num - left, length);
                hashMap.put(num + right, length);
                if (length > res) {
                    res = length;
                }
            }
        }
        return res;
    }
}

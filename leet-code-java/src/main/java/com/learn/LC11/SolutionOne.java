package com.learn.LC11;

public class SolutionOne {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int biggest = 0;
        while (left < right) {
            int small = Math.min(height[left], height[right]);
            int value = small * (right - left);
            biggest = Math.max(value, biggest);
            if (small == height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return biggest;
    }
}

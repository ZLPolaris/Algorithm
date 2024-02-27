package com.learn.LC42;

// 思考不够清晰
public class SolutionOne {
    public int trap(int[] height) {
        int left = 0;
        int heightLength = height.length;
        int waterCapacity = 0;
        while (left < heightLength - 1) {
            while (left < heightLength - 1 && height[left] <= height[left + 1]) {
                left++;
            }
            if (left == heightLength - 1) {
                return waterCapacity;
            }

            int right = left + 1;
            int sum = 0;
            while (right < heightLength && height[right] < height[left]) {
                sum += height[right];
                right++;
            }
            if (right == heightLength) {
                break;
            } else {
                waterCapacity += (right - left - 1) * height[left] - sum;
                left = right;
            }
        }
        return waterCapacity;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().trap(new int[]{4, 2, 3}));
    }
}

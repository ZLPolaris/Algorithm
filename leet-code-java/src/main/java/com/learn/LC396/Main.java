package com.learn.LC396;

class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int numSum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            numSum += nums[i];
            max += i * nums[i];
        }
        int front = max;
        for (int i = 1; i < n; i++) {
            front = front + numSum - nums[n - i] * n;
            if (front > max) {
                max = front;
            }
        }
        return max;
    }
}


public class Main {

    public static void main(String[] args) {

    }
}

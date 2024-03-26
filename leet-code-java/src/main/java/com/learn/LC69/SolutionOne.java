package com.learn.LC69;

public class SolutionOne {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            double key = (double) x / mid / mid;
            if (key == 1) {
                return mid;
            } else if (key < 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().mySqrt(2147395599));
    }
}

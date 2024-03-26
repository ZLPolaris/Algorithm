package com.learn.LC528;

public class SolutionOne {

}

class Solution {
    private int n = 0;
    private int[] pre = null;
    private int sum = 0;

    public Solution(int[] w) {
        this.n = w.length;
        pre = new int[n];
        pre[0] = w[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + w[i];
        }
        sum = pre[n - 1];
    }

    public int pickIndex() {
        int key = (int) (Math.random() * sum) + 1;
        return binarySearch(key);
    }

    private int binarySearch(int target) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (pre[mid] == target) {
                return mid;
            } else if (pre[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
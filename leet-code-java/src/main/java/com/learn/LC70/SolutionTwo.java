package com.learn.LC70;

public class SolutionTwo {
    public int climbStairs(int n) {
        int first = 1;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int tmp =second;
            second = second + first;
            first = tmp;
        }
        return second;
    }
}

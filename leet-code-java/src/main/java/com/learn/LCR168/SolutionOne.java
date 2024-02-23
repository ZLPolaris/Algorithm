package com.learn.LCR168;

public class SolutionOne {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int d2 = res[p2] * 2, d3 = res[p3] * 3, d5 = res[p5] * 5;
            int smallest = Math.min(d2, Math.min(d3, d5));
            if (smallest == d2) {
                p2++;
            }
            if (smallest == d3) {
                p3++;
            }
            if (smallest == d5) {
                p5++;
            }
            res[i] = smallest;
        }
        return res[n - 1];
    }
}

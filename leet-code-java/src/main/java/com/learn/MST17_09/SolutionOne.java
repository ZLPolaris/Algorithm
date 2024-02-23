package com.learn.MST17_09;

public class SolutionOne {
    public int getKthMagicNumber(int k) {
        int[] res = new int[k];
        res[0] = 1;
        int p3 = 0, p5 = 0, p7 = 0;
        for (int i = 1; i < k; i++) {
            int d3 = res[p3] * 3, d5 = res[p5] * 5, d7 = res[p7] * 7;
            int smallest = Math.min(d3, Math.min(d5, d7));
            if (smallest == d3) {
                p3++;
            }
            if (smallest == d5) {
                p5++;
            }
            if (smallest == d7) {
                p7++;
            }
            res[i] = smallest;
        }
        return res[k - 1];
    }
}

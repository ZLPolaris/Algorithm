package com.learn.LC264;

public class SolutionTwo {
}
class Solution {
    public int nthUglyNumber(int n) {
        int[] data = new int[n];
        data[0] = 1;
        for (int p1 = 0, p2 = 0, p3 = 0,idx = 1;idx < n; idx++){
            int d1 = data[p1] * 2;
            int d2 = data[p2] * 3;
            int d3 = data[p3] * 5;
            int smallest = Math.min(d1, Math.min(d2, d3));
            // 此处三个单if 排除了多路归并中相等的情况。
            if(smallest == d1){
                p1++;
            }
            if (smallest == d2) {
                p2++;
            }
            if(smallest == d3) {
                p3++;
            }
            data[idx] = smallest;
        }
        return data[n-1];
    }
}

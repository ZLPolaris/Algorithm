package com.learn.LCR170;

// 采用冒泡排序思想会超时  n^2
public class SolutionOne {
    public int reversePairs(int[] record) {
        int res = 0;
        int n = record.length;
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if(record[j]  > record[j + 1]){
                    res++;
                    int tmp = record[j + 1];
                    record[j + 1] = record[j];
                    record[j] = tmp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
            System.out.println();
        }
        return res;
    }
}

package com.learn.LC1337;

import java.util.PriorityQueue;

public class SolutionOne {
    private int compare(int[][] mat, int o1, int o2) {
        int n = mat[0].length;
        for (int i = 0; i < n; i++) {
            if (mat[o1][i] != mat[o2][i]) {
                return mat[o2][i] - mat[o1][i];
            }
        }
        return o2 - o1;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> this.compare(mat, o1, o2));
        for (int i = 0; i < m; i++) {
            if (i < k) {
                priorityQueue.offer(i);
            } else {
                if (this.compare(mat, priorityQueue.peek(), i) < 0) {
                    priorityQueue.poll();
                    priorityQueue.offer(i);
                }
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            int tail = priorityQueue.poll();
            res[i] = tail;
        }
        return res;
    }
}

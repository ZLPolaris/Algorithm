package com.learn.LCR183;

import java.util.PriorityQueue;

public class SolutionOne {
    public int[] maxAltitude(int[] heights, int limit) {
        if (limit == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < limit - 1; i++) {
            priorityQueue.offer(heights[i]);
        }
        int heightLength = heights.length;
        int[] res = new int[heightLength - limit + 1];
        for (int i = 0; i < heightLength - limit + 1; i++) {
            priorityQueue.offer(heights[i + limit - 1]);
            res[i] = priorityQueue.peek();
            priorityQueue.remove(heights[i]);

        }
        return res;
    }
}

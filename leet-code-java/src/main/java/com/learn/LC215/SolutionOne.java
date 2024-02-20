package com.learn.LC215;

import java.util.PriorityQueue;

public class SolutionOne {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int num : nums) {
            priorityQueue.offer(num);
        }
        while (k > 1) {
            priorityQueue.poll();
            k--;
        }
        return priorityQueue.peek();
    }
}

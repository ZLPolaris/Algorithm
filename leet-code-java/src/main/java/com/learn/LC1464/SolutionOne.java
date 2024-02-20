package com.learn.LC1464;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionOne {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for(int num : nums){
            priorityQueue.offer(num);
        }
        return (priorityQueue.poll() - 1) * (priorityQueue.poll() - 1);
    }
}

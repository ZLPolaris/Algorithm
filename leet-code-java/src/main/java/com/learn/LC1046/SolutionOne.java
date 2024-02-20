package com.learn.LC1046;

import java.util.List;
import java.util.PriorityQueue;

public class SolutionOne {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) {
            priorityQueue.add(stone);
        }
        while (priorityQueue.size() > 1) {
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            if (first > second) {
                priorityQueue.add(first - second);
            }
        }
        return !priorityQueue.isEmpty() ? priorityQueue.peek() : 0;
    }
}

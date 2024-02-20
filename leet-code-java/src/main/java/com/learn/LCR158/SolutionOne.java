package com.learn.LCR158;

import java.util.PriorityQueue;

public class SolutionOne {
    public int[] inventoryManagement(int[] stock, int cnt) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int data : stock){
            priorityQueue.offer(data);
        }
        int[] res = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }
}

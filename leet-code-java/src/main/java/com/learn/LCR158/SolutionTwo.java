package com.learn.LCR158;

import java.util.PriorityQueue;

public class SolutionTwo {
    public int[] inventoryManagement(int[] stock, int cnt) {
        int[] res = new int[cnt];
        if(cnt == 0){
            return res;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int i = 0; i < cnt; i++) {
            priorityQueue.add(stock[i]);
        }
        for (int i = cnt; i < stock.length; i++) {
            if(stock[i] < priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(stock[i]);
            }
        }
        for (int i = 0; i < cnt; i++) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }
}

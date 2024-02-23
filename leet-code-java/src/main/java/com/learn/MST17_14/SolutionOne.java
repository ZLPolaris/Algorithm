package com.learn.MST17_14;

import java.util.PriorityQueue;

public class SolutionOne {
    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        if(k == 0){
            return res;
        }
        int arrLength = arr.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int i = 0; i < arrLength; i++) {
            if(i < k){
                priorityQueue.offer(arr[i]);
            }else {
                if(arr[i] < priorityQueue.peek()){
                    priorityQueue.poll();
                    priorityQueue.offer(arr[i]);
                }
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }
}

package com.learn.LCR60;

import java.util.HashMap;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.PriorityQueue;

public class SolutionOne {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> hashMap.get(o1) - hashMap.get(o2));
        int p = 0;
        for (int key : hashMap.keySet()) {
            if (p < k) {
                priorityQueue.offer(key);
            } else {
                if (hashMap.get(key) > hashMap.get(priorityQueue.peek())) {
                    priorityQueue.poll();
                    priorityQueue.offer(key);
                }
            }
            p++;
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }
}

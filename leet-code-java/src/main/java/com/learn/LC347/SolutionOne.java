package com.learn.LC347;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SolutionOne {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(((o1, o2) -> o2[0] - o1[0]));
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
            priorityQueue.add(new int[]{hashMap.get(num), num});
        }
        int[] res = new int[k];
        int i = 0;
        while (i < k){
            int[] peek = priorityQueue.poll();
            if(hashMap.get(peek[1]) > 0){
                res[i] = peek[1];
                hashMap.put(peek[1], 0);
                i++;
            }
        }
        return res;
    }
}

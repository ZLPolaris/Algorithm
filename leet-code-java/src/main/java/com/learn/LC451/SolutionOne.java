package com.learn.LC451;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SolutionOne {
    public String frequencySort(String s) {
        HashMap<String, Integer> charCount = new HashMap<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(((o1, o2) -> charCount.get(o2) - charCount.get(o1)));
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i + 1);
            if (!charCount.containsKey(str)) {
                charCount.put(str, 1);
            } else {
                charCount.put(str, charCount.get(str) + 1);
            }
        }
        for (String key : charCount.keySet()) {
            priorityQueue.offer(key);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            String str = priorityQueue.poll();
            stringBuilder.append(String.valueOf(str).repeat(Math.max(0, charCount.get(str))));
        }
        return stringBuilder.toString();
    }
}

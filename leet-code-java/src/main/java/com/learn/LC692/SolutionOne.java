package com.learn.LC692;

import java.util.*;

// 总结一下 topK排序书写规则
// 此题，我们把题目字典排序规则 称为 大于函数
// 小根堆即小于函数
public class SolutionOne {
    private int compare(HashMap<String, Integer> wordsCount, String o1, String o2) {
        if (!Objects.equals(wordsCount.get(o1), wordsCount.get(o2))) {
            return wordsCount.get(o1) - wordsCount.get(o2);
        } else {
            return o2.compareTo(o1);
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add("");
        }
        if (k == 0) {
            return res;
        }
        HashMap<String, Integer> wordsCount = new HashMap<>();
        for (String word : words) {
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(((o1, o2) -> this.compare(wordsCount, o1, o2)));
        int p = 0;
        for (String key : wordsCount.keySet()) {
            if (p < k) {
                priorityQueue.offer(key);
            } else {
                if (this.compare(wordsCount, priorityQueue.peek(), key) < 0) {
                    priorityQueue.poll();
                    priorityQueue.offer(key);
                }
            }
            p++;
        }
        for (int i = k - 1; i >= 0; i--) {
            res.set(i, priorityQueue.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }
}

package com.learn.LC239;

import java.util.Arrays;
import java.util.PriorityQueue;

// 8m
public class SolutionOne {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int numsLength = nums.length;
        int end = numsLength - k + 1;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            } else {
                return o2[1] - o2[0];
            }
        });
        for (int i = 0; i < k - 1; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
        }
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            priorityQueue.offer(new int[]{nums[i + k - 1], i + k - 1});
            while (priorityQueue.peek()[1] < i) {
                priorityQueue.poll();
            }
            int[] peek = priorityQueue.peek();
            res[i] = peek[0];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SolutionOne().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}

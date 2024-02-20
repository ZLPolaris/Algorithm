package com.learn.LC719;

import java.util.PriorityQueue;

public class SolutionTwo {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int arrLength = arr.length;
        int[] pointers = new int[arrLength];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> arr[pointers[o1]] * arr[o2] - arr[pointers[o2]] * arr[o1]);
        for (int i = 1; i < arrLength; i++) {
            priorityQueue.offer(i);
        }
        while (true) {
            int index = priorityQueue.poll();
            if (k == 1) {
                return new int[]{arr[pointers[index]], arr[index]};
            }
            pointers[index]++;
            if (pointers[index] < index) {
                priorityQueue.offer(index);
            }
            k--;
        }
    }
}

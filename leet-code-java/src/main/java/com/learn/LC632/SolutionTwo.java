package com.learn.LC632;


import java.util.List;
import java.util.PriorityQueue;

public class SolutionTwo {
    public int[] smallestRange(List<List<Integer>> nums) {
        int listNumber = nums.size();
        int[] pointers = new int[listNumber];
        int smallest = Integer.MAX_VALUE;
        int[] res = new int[2];
        int biggestIndex = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> nums.get(o1).get(pointers[o1]) - nums.get(o2).get(pointers[o2])));
        for (int i = 0; i < listNumber; i++) {
            priorityQueue.offer(i);
            if (nums.get(biggestIndex).get(pointers[biggestIndex]) < nums.get(i).get(pointers[i])) {
                biggestIndex = i;
            }
        }
        while (true) {
            int smallestIndex = priorityQueue.poll();
            int sectionLength = nums.get(biggestIndex).get(pointers[biggestIndex]) - nums.get(smallestIndex).get(pointers[smallestIndex]);
            if (sectionLength < smallest) {
                res[0] = nums.get(smallestIndex).get(pointers[smallestIndex]);
                res[1] = nums.get(biggestIndex).get(pointers[biggestIndex]);
                smallest = sectionLength;
            }
            pointers[smallestIndex]++;
            if (pointers[smallestIndex] >= nums.get(smallestIndex).size()) {
                break;
            }
            priorityQueue.offer(smallestIndex);
            if (nums.get(smallestIndex).get(pointers[smallestIndex]) > nums.get(biggestIndex).get(pointers[biggestIndex])) {
                biggestIndex = smallestIndex;
            }
        }
        return res;
    }
}

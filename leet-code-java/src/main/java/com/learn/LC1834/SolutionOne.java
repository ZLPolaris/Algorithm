package com.learn.LC1834;

import java.util.PriorityQueue;

public class SolutionOne {
    public int[] getOrder(int[][] tasks) {
        int time = 1;
        int tasksLength = tasks.length;
        int finishedTime = 1;
        int k = 0;
        int[] res = new int[tasksLength];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> (tasks[o1][1] - tasks[o1][0]) - (tasks[o2][1] - tasks[o2][0]));
        int enqueueIndex = 0;
        while (k < tasksLength) {
            for (; enqueueIndex < tasksLength && tasks[enqueueIndex][0] >= time; enqueueIndex++) {
                priorityQueue.add(enqueueIndex);
            }
            if (time >= finishedTime) {
                if (!priorityQueue.isEmpty()) {
                    int taskId = priorityQueue.poll();
                    finishedTime = time + tasks[taskId][1] - tasks[taskId][0];
                    res[k++] = taskId;
                }
            }
            time++;
        }
        return res;
    }
}

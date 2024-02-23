package com.learn.LC1834;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionTwo {
    public int[] getOrder(int[][] tasks) {
        int tasksLength = tasks.length;
        Integer[] tasksId = new Integer[tasksLength];
        for (int i = 0; i < tasksLength; i++) {
            tasksId[i] = i;
        }
        Arrays.sort(tasksId, Comparator.comparingInt(o -> tasks[o][0]));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> {
            if (tasks[o1][1] != tasks[o2][1]) {
                return tasks[o1][1] - tasks[o2][1];
            } else {
                return o1 - o2;
            }
        }));
        int[] res = new int[tasksLength];
        int idx = 0;
        int time = 1;
        int k = 0;
        while (k < tasksLength) {
            if (priorityQueue.isEmpty()) {
                time = Math.max(time, tasks[tasksId[idx]][0]);
            }
            while (idx < tasksLength && tasks[tasksId[idx]][0] <= time) {
                priorityQueue.offer(tasksId[idx]);
                idx++;
            }
            int executiveTaskId = priorityQueue.poll();
            time += tasks[executiveTaskId][1];
            res[k++] = executiveTaskId;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SolutionTwo().getOrder(new int[][]{
                {1, 2}, {2, 4}, {3, 2}, {4, 1},
        })));
    }
}

package com.learn.LC786;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;

// 会超时
class Pair {
    private Integer left;
    private Integer right;

    public Pair() {
    }

    public Pair(Integer left, Integer right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pair objs) {
            return Objects.equals(this.left, objs.left) && Objects.equals(this.right, objs.right);
        }
        return false;
    }
}

public class SolutionOne {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int arrLength = arr.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(((o1, o2) -> {
            double p1 = (double) arr[o1[0]] / arr[o1[1]];
            double p2 = (double) arr[o2[0]] / arr[o2[1]];
            return Double.compare(p1, p2);
        }));
        priorityQueue.add(new int[]{0, arrLength - 1});
        HashSet<Pair> hashSet = new HashSet<>();
        while (k > 0) {
            int[] data = priorityQueue.poll();
            int left = data[0];
            int right = data[1];
            if (k == 1) {
                return new int[]{arr[left], arr[right]};
            }
            if (right - left > 1) {
                Pair leftPair = new Pair(left + 1, right);
                Pair rightPair = new Pair(left, right - 1);
                if (!hashSet.contains(leftPair)) {
                    hashSet.add(leftPair);
                    priorityQueue.offer(new int[]{left + 1, right});
                }
                if (!hashSet.contains(rightPair)) {
                    hashSet.add(rightPair);
                    priorityQueue.offer(new int[]{left, right - 1});
                }
            }
            k--;
        }
        return null;
    }

//    public static void main(String[] args) {
//        new SolutionOne().kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3);
//    }
}

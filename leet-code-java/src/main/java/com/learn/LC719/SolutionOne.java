package com.learn.LC719;

import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;

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
    public int smallestDistancePair(int[] nums, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(((o1, o2) -> o2[0] - o1[0]));
        int numsLength = nums.length;
        Arrays.sort(nums);
        HashSet<Pair> hashSet = new HashSet<>();
        priorityQueue.offer(new int[]{nums[numsLength - 1] - nums[0], 0, numsLength - 1});
        int i = (numsLength - 1) * numsLength / 2 + 1 - k;
        while (i > 0) {
            int[] data = priorityQueue.poll();
            int left = data[1];
            int right = data[2];
            int value = data[0];
            if (i == 1) {
                return value;
            }
            if (right - left > 1) {
                Pair leftPair = new Pair(left, right - 1);
                if (!hashSet.contains(leftPair)) {
                    hashSet.add(leftPair);
                    priorityQueue.offer(new int[]{nums[right - 1] - nums[left], left, right - 1});
                }
                Pair rightPair = new Pair(left + 1, right);
                if (!hashSet.contains(rightPair)) {
                    hashSet.add(rightPair);
                    priorityQueue.offer(new int[]{nums[right] - nums[left + 1], left + 1, right});
                }
            }
            i--;
        }
        return -1;
    }

//    public static void main(String[] args) {
//        new SolutionOne().smallestDistancePair(new int[]{2, 2, 0, 1, 1, 0, 0, 1, 2, 0}, 1);
//    }
}

package com.learn.LC875;

import java.util.Arrays;
import java.util.OptionalInt;

public class SolutionOne {
    public int minEatingSpeed(int[] piles, int h) {
        OptionalInt optionalInt = Arrays.stream(piles).max();
        if (optionalInt.isEmpty()) {
            return -1;
        }
        return binarySearch(piles, optionalInt.getAsInt(), h);
    }

    private int binarySearch(int[] piles, int top, int h) {
        int left = 1;
        int right = top;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            long time = getTime(piles, mid);
            if (time > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private long getTime(int[] piles, int speed) {
        long time = 0;
        for (int pile : piles) {
            time += Math.ceilDiv(pile, speed);
        }
        return time;
    }
}

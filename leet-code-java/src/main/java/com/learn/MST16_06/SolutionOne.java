package com.learn.MST16_06;

import java.util.Arrays;

public class SolutionOne {
    public int smallestDifference(int[] a, int[] b) {
        if (a.length > b.length) {
            return getSmallestDifference(Arrays.stream(b).sorted().toArray(), a);
        } else {
            return getSmallestDifference(Arrays.stream(a).sorted().toArray(), b);
        }
    }

    private int getSmallestDifference(int[] sortedArray, int[] unsortedArray) {
        long res = Long.MAX_VALUE;
        for (int num : unsortedArray) {
            int pos = Arrays.binarySearch(sortedArray, num);
            if (pos < 0) {
                pos = -pos - 1;
            }
            System.out.println(pos);
            if (pos > 0) {
                res = Math.min(res, (long)num - sortedArray[pos - 1]);
            }
            if (pos < sortedArray.length) {
                res = Math.min(res, (long)sortedArray[pos] - num);
            }
        }
        return (int) res;
    }
}

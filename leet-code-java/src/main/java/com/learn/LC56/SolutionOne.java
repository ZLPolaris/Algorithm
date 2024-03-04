package com.learn.LC56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SolutionOne {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> arrayList = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int intervalLength = intervals.length;
        arrayList.add(intervals[0]);
        for (int i = 1; i < intervalLength; i++) {
            int end = arrayList.get(arrayList.size() - 1)[1];
            if (intervals[i][0] <= end) {
                arrayList.get(arrayList.size() - 1)[1] = Math.max(intervals[i][1], end);
            } else {
                arrayList.add(intervals[i]);
            }
        }
        int[][] res = new int[arrayList.size()][];
        for (int i = 0; i < arrayList.size(); i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }
}

package com.learn.LC539;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SolutionOne {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int key = 23 * 60 + 59 + 1;
        int[] timestamp = new int[n];
        for (int i = 0; i < n; i++) {
            timestamp[i] = getTime(timePoints.get(i));
        }
        timestamp = Arrays.stream(timestamp).sorted().toArray();
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.min(res, timestamp[i] - timestamp[i - 1]);
            if (res == 0) {
                return 0;
            }
        }
        res = Math.min(res, timestamp[0] + key - timestamp[n - 1]);
        return res;
    }

    private int getTime(String time) {
        int res = 0;
        String[] str = time.split(":");
        res += Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
        return res;
    }
}


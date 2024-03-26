package com.learn.LC729;

import java.util.ArrayList;

public class SolutionOne {
}

class MyCalendar {
    private final ArrayList<int[]> task;

    {
        task = new ArrayList<>();
    }

    public MyCalendar() {
    }

    public boolean book(int start, int end) {
        int insertIndex = binarySearch(start);
        if (insertIndex < task.size() &&  task.get(insertIndex)[0] < end) {
            return false;
        }
        if (insertIndex > 0 && task.get(insertIndex - 1)[1] > start) {
            return false;
        }
        task.add(insertIndex, new int[]{start, end});
        return true;
    }

    private int binarySearch(int start) {
        int n = task.size();
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int midS = task.get(mid)[0];
            if (midS == start) {
                return mid;
            } else if (midS > start) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/*
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
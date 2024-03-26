package com.learn.MST10_10;

import java.util.ArrayList;
import java.util.Arrays;

public class SolutionOne {
}

class StreamRank {
    private final ArrayList<Integer> data;

    {
        data = new ArrayList<>();
    }

    public StreamRank() {
    }

    public void track(int x) {
        int pos = binarySearch(x);
        data.add(pos, x);
    }

    public int getRankOfNumber(int x) {
        return binarySearch(x);
    }

    private int binarySearch(int x) {
        int left = 0;
        int right = data.size() - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (data.get(mid) <= x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
        return left;
    }

    public static void main(String[] args) {
        StreamRank streamRank = new StreamRank();
        streamRank.track(1);
        streamRank.track(6);
        streamRank.track(7);
        streamRank.track(8);
        System.out.println(streamRank.getRankOfNumber(2));
    }
}
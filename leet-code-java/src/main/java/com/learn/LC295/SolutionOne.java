package com.learn.LC295;

import java.util.ArrayList;

class MedianFinder {
    private final ArrayList<Integer> arrayList = new ArrayList<>();

    public MedianFinder() {
    }

    public void addNum(int num) {
        int arrayLength = this.arrayList.size();
        int i = 0;
        while (i < arrayLength && this.arrayList.get(i) <= num) {
            i++;
        }
        this.arrayList.add(i, num);
    }

    public double findMedian() {
        int arrayLength = this.arrayList.size();
        if ((arrayLength & 1) == 1) {
            return this.arrayList.get(arrayLength >> 1);
        } else {
            return (double) (this.arrayList.get(arrayLength >> 1) + this.arrayList.get((arrayLength >> 1) - 1)) / 2;
        }
    }
}

public class SolutionOne {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
    }

/*
  Your MedianFinder object will be instantiated and called as such:
  MedianFinder obj = new MedianFinder();
  obj.addNum(num);
  double param_2 = obj.findMedian();
 */
}

package com.learn.LCR160;

import java.util.PriorityQueue;

public class SolutionOne {
}

class MedianFinder {

    private final PriorityQueue<Integer> queueMin = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private final PriorityQueue<Integer> queueMax = new PriorityQueue<>();
    private Double median = Double.MAX_VALUE;

    /** initialize your data structure here. */
    public MedianFinder() {
    }

    public void addNum(int num) {
        int queueMinSize = queueMin.size();
        int queueMaxSize = queueMax.size();
        if (num <= median) {
            queueMin.offer(num);
            if (queueMinSize > queueMaxSize) {
                queueMax.offer(queueMin.poll());
            }
        } else {
            queueMax.offer(num);
            if (queueMinSize == queueMaxSize) {
                queueMin.offer(queueMax.poll());
            }
        }
        if (this.queueMin.size() == this.queueMax.size()) {
            this.median = (double) (this.queueMax.peek() + this.queueMin.peek()) / 2;
        } else {
            this.median = (double) this.queueMin.peek();
        }
    }

    public double findMedian() {
        return this.median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
package com.learn.LC295;

import java.util.PriorityQueue;

class MedianFinders {

    private final PriorityQueue<Integer> queueMin = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private final PriorityQueue<Integer> queueMax = new PriorityQueue<>();
    private Double median = Double.MAX_VALUE;

    public MedianFinders() {
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
            if (queueMaxSize == queueMinSize) {
                queueMin.offer(queueMax.poll());
            }
        }
        if (queueMin.size() == queueMax.size()) {
            this.median = (double) (queueMin.peek() + queueMax.peek()) / 2;
        } else {
            this.median = (double) queueMin.peek();
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
public class SolutionTwo {
    public static void main(String[] args) {
        MedianFinders medianFinders = new MedianFinders();
        medianFinders.addNum(1);
        medianFinders.addNum(2);
        medianFinders.addNum(3);
        medianFinders.addNum(4);
        System.out.println(medianFinders.findMedian());
    }
}

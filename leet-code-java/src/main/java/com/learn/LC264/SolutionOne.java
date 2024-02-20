package com.learn.LC264;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SolutionOne {
}
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        Set<Long> data = new HashSet<>();
        data.add(1L);
        for (int i = 1; i <= n; i++) {
            long tail = queue.poll();
            if(i == n){
                return (int)tail;
            }
            long d1 = tail * 2;
            if(!data.contains(d1)){
                data.add(d1);
                queue.offer(d1);
            }
            long d2 = tail * 3;
            if(!data.contains(d2)){
                data.add(d2);
                queue.offer(d2);
            }
            long d3 = tail * 5;
            if(!data.contains(d3)){
                data.add(d3);
                queue.offer(d3);
            }
        }
        return -1;
    }
}
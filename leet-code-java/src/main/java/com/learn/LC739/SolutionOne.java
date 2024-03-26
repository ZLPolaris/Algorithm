package com.learn.LC739;

import java.util.Deque;
import java.util.LinkedList;

public class SolutionOne {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int temperaturesLength = temperatures.length;
        int[] answer = new int[temperaturesLength];
        stack.push(0);
        for (int i = 1; i < temperaturesLength; i++) {
            while (!stack.isEmpty() &&  temperatures[i] > temperatures[stack.peek()]){
                int key = stack.pop();
                answer[key] = i - key;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            answer[stack.pop()] = 0;
        }
        return answer;
    }
}

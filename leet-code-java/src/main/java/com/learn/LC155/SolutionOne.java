package com.learn.LC155;

import java.util.Deque;
import java.util.LinkedList;

public class SolutionOne {
}

class MinStack {
    private Deque<int[]> stack = new LinkedList<>();

    public MinStack() {
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
        } else {
            int[] peek = new int[2];
            peek[0] = val;
            peek[1] = Math.min(val, stack.peek()[1]);
            stack.push(peek);
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek()[0];
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
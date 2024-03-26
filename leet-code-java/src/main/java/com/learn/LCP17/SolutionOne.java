package com.learn.LCP17;

public class SolutionOne {
    public int calculate(String s) {
        int x = 1, y = 0;
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (key == 'A') {
                x = A(x, y);
            } else {
                y = B(x, y);
            }
        }
        return x + y;
    }

    public int A(int x, int y) {
        return 2 * x + y;
    }

    public int B(int x, int y) {
        return 2 * y + x;
    }
}

package com.learn.LC400;

import java.util.ArrayList;

public class SolutionOne {
    public int findNthDigit(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            long nth = getNumberNth(mid);
            if (nth < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        long leftNth = getNumberNth(left);
        System.out.println(left);
        System.out.println(leftNth);
        return getTheNumberNth(left, (int) (leftNth - n));
    }

    private long getNumberNth(int number) {
        int tmp = number;
        long nth = 0;
        int i = 1;
        int p = 1;
        while (number / 10 != 0) {
            nth += 9L * p * i;
            i++;
            p = p * 10;
            number /= 10;
        }
        nth += (long) (tmp - p + 1) * i;
        return nth;
    }

    private int getTheNumberNth(int number, int n) {    
        int i = 0;
        while (number / 10 != 0 && i < n) {
            number /= 10;
            i++;
        }
        return number % 10;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().findNthDigit(10000));
    }

}

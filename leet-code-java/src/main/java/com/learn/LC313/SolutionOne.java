package com.learn.LC313;

import java.util.PriorityQueue;

public class SolutionOne {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int primeLength = primes.length;
        int[] pointers = new int[primeLength];
        long[] uglyNumbers = new long[n];
        uglyNumbers[0] = 1;
        for (int idx = 1; idx < n; idx++) {
            long smallest = getMin(uglyNumbers, pointers, primes);
            uglyNumbers[idx] = smallest;
        }
        return (int)uglyNumbers[n - 1];
    }

    private long getMin(long[] uglyNumbers, int[] pointer, int[] primes) {
        int smallestIndex = 0;
        for (int i = 1; i < pointer.length; i++) {
            if (uglyNumbers[pointer[i]] * primes[i] < uglyNumbers[pointer[smallestIndex]] * primes[smallestIndex]) {
                smallestIndex = i;
            }
        }
        long smallest = uglyNumbers[pointer[smallestIndex]] * primes[smallestIndex];
        for (int i = 0; i < pointer.length; i++) {
            if (uglyNumbers[pointer[i]] * primes[i] == smallest) {
                pointer[i]++;
            }
        }
        return smallest;
    }
}

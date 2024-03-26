package com.learn.MST16_21;

import java.util.Arrays;
import java.util.HashSet;

public class SolutionOne {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = Arrays.stream(array1).sum();
        int sum2 = Arrays.stream(array2).sum();
        if((Math.abs(sum2 - sum1) & 1) == 1){
            return new int[]{};
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : array2) {
            hashSet.add(num);
        }
        for (int num : array1) {
            if (hashSet.contains(num + (sum2 - sum1) / 2)) {
                return new int[]{num, num + (sum2 - sum1) / 2};
            }
        }
        return new int[]{};
    }
}

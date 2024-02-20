package com.learn.LC632;


import java.util.List;

public class SolutionOne {
    public int[] smallestRange(List<List<Integer>> nums) {
        int listNumber = nums.size();
        int[] pointers = new int[listNumber];
        boolean flag = true;
        int smallest = Integer.MAX_VALUE;
        int[] res = new int[2];
        while (flag) {
            int minIndex = 0, maxIndex = 0;
            for (int i = 1; i < listNumber; i++) {
                if (nums.get(i).get(pointers[i]) > nums.get(maxIndex).get(pointers[maxIndex])) {
                    maxIndex = i;
                }
                if (nums.get(i).get(pointers[i]) < nums.get(minIndex).get(pointers[minIndex])) {
                    minIndex = i;
                }
            }
            int sectionLength = nums.get(maxIndex).get(pointers[maxIndex]) - nums.get(minIndex).get(pointers[minIndex]);
            if(sectionLength < smallest){
                res[0] = nums.get(minIndex).get(pointers[minIndex]);
                res[1] = nums.get(maxIndex).get(pointers[maxIndex]);
                smallest = sectionLength;
            }
            pointers[minIndex] ++;
            if(pointers[minIndex] >= nums.get(minIndex).size()){
                flag = false;
            }
        }
        return res;
    }
}

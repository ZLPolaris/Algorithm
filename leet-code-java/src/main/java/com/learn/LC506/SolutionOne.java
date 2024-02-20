package com.learn.LC506;

import java.util.Arrays;
import java.util.HashMap;

public class SolutionOne {
    private Integer heapSize;
    private void buildHeap(int[] score){
        int n = score.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            this.minHeapify(score, i);
        }
    }
    private void minHeapify(int[] score, int target){
        int smallest = target;
        if(target * 2 + 1 < this.heapSize && score[target * 2 + 1] < score[smallest]){
            smallest = target * 2 + 1;
        }
        if(target * 2 + 2 < this.heapSize && score[target * 2 + 2] < score[smallest]){
            smallest = target * 2 + 2;
        }
        if(smallest != target){
            int tmp = score[smallest];
            score[smallest] = score[target];
            score[target] = tmp;
            minHeapify(score, smallest);
        }
    }

    public String[] findRelativeRanks(int[] score) {
        int[] origin = score.clone();
        this.heapSize = score.length;
        buildHeap(score);
        int n = score.length;
        // 堆排序
        for (int i = n - 1; i > 0 ; i--) {
            int tmp = score[i];
            score[i] = score[0];
            score[0] = tmp;
            this.heapSize--;
            minHeapify(score, 0);
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashMap.put(score[i], i);
        }
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            int rank = hashMap.get(origin[i]);
            switch (rank){
                case 0:
                    res[i] = "Gold Medal";
                    break;
                case 1:
                    res[i] = "Silver Medal";
                    break;
                case 2:
                    res[i] = "Bronze Medal";
                    break;
                default:
                    res[i] = String.format("%s", rank + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SolutionOne().findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
    }

}

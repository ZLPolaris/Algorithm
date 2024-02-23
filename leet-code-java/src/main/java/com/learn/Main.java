package com.learn;

import com.learn.LC719.SolutionOne;

import java.util.Arrays;

public class Main {
    public void qSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int partitionNumber = arr[left];
        int p1 = left, p2 = right;
        while (p1 < p2) {
            while (p1 < p2 && arr[p2] >= partitionNumber) {
                p2--;
            }
            arr[p1] = arr[p2];
            while (p1 < p2 && arr[p1] <= partitionNumber) {
                p1++;
            }
            arr[p2] = arr[p1];
        }
        arr[p1] = partitionNumber;
        int mid = p1;
        qSort(arr, left, mid - 1);
        qSort(arr, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{98, 9, 51, -18, 64};
        new Main().qSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
package com.learn.LCR170;


import java.util.Arrays;

public class SolutionTwo {
    public int reversePairs(int[] record) {
        if (record.length == 0) {
            return 0;
        }
        return mergeSort(record, new int[record.length], 0, record.length - 1);
    }

    private int mergeSort(int[] record, int[] reg, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        int leftCount = mergeSort(record, reg, left, mid);
        int rightCount = mergeSort(record, reg, mid + 1, right);
//        System.out.println(leftCount);
//        System.out.println(rightCount);
//        System.out.println("-------------");
        int point1 = left;
        int point2 = mid + 1;
        int k = left;
        int count = 0;
        while (point1 <= mid && point2 <= right) {
            // 不会产生逆序对
            if (record[point1] <= record[point2]) {
                reg[k++] = record[point1++];
            } else {
//                System.out.println(Arrays.toString(record));
//                // 后面的元素小 产生逆序对
//                System.out.println(point1);
//                System.out.println(point2);
//                System.out.println("+++++++++++");
                count += mid - point1 + 1;
                reg[k++] = record[point2++];
            }
        }
        while (point1 <= mid) {
            reg[k++] = record[point1++];
        }
        while (point2 <= right) {
            reg[k++] = record[point2++];
        }
        System.arraycopy(reg, left, record, left, right + 1 - left);
        return leftCount + rightCount + count;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionTwo().reversePairs(new int[]{7, 5, 6, 4}));
    }
}

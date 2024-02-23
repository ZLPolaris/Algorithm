package com.learn.LCR159;

import java.util.Arrays;

public class SolutionOne {
    public int selectK(int[] stock, int k, int left, int right) {
        if(k == 0){
            return -1;
        }
        int partitionNumber = stock[left];
        int p1 = left, p2 = right;
        while (p1 < p2 ){
            while (p1 < p2 && stock[p2] >= partitionNumber){
                p2--;
            }
            stock[p1] = stock[p2];
            while (p1 < p2 && stock[p1] <= partitionNumber){
                p1++;
            }
            stock[p2] = stock[p1];
        }
        int mid = p1;
        stock[mid] = partitionNumber;
        int nth = mid - left + 1;
        if (nth > k) {
            return selectK(stock, k, left, mid - 1);
        } else if (nth < k) {
            return selectK(stock, k - nth, mid + 1, right);
        } else {
            return mid;
        }
    }

    public int[] inventoryManagement(int[] stock, int cnt) {
        this.selectK(stock, cnt, 0, stock.length - 1);

        int[] res = new int[cnt];
        System.arraycopy(stock, 0, res, 0, cnt);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SolutionOne().inventoryManagement(new int[]{2, 5, 7, 4}, 0)));

    }
}

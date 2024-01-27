package com.learn.LC357;

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int add = 1;
        int front = 9;
        for (int i = 1; i <= n && i <= 10; i++) {
            add += front;
            front *= 10 - i;
        }
        return add;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countNumbersWithUniqueDigits(3));
    }
}

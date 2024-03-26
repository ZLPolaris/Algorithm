package com.learn.LC45;

public class SolutionOne {
    public int jump(int[] nums) {
        int numsLength = nums.length;
        int select = 0;
        int res = 0;
        while (select < numsLength - 1) {
            if (nums[select] + select >= numsLength - 1) {
                select = numsLength - 1;
            } else {
                int index = select + 1;
                for (int i = select + 1; i <= nums[select] + select; i++) {
                    if (nums[index] + index < nums[i] + i) {
                        index = i;
                    }
                }
                select = index;
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().jump(new int[]{2,3,0,1,4}));
    }
}

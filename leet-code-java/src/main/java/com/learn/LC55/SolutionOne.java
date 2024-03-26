package com.learn.LC55;

public class SolutionOne {
    public boolean canJump(int[] nums) {
        int numsLength = nums.length;
        int index = 0;
        while (index < numsLength - 1 && nums[index] != 0) {
            int select = index + 1;
            for (int i = index + 1; i <= index + nums[index] && i < numsLength; i++) {
                if (select + nums[select] <= i + nums[i]) {
                    select = i;
                }
            }
            index = select;
        }
        return index >= numsLength - 1;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().canJump(new int[]{2,0}));
    }
}

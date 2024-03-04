package com.learn.LC78;

import java.util.ArrayList;
import java.util.List;

public class SolutionOne {
    private Integer numsLength = 0;
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        this.numsLength = nums.length;
        this.getSubsets(nums, 0);
        return this.res;
    }

    private void getSubsets(int[] nums, int index) {
        if (index == this.numsLength) {
            res.add(new ArrayList<>(path));
            return;
        }
        this.getSubsets(nums, index + 1);
        path.add(nums[index]);
        this.getSubsets(nums, index + 1);
        path.remove(path.size() - 1);

    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().subsets(new int[]{1, 2, 3}));
    }
}

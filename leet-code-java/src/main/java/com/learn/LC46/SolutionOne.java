package com.learn.LC46;

import java.util.ArrayList;
import java.util.List;

public class SolutionOne {
    private int[] colors = null;
    private int numsLength = 0;
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        this.numsLength = nums.length;
        colors = new int[numsLength];
        this.getPermute(nums,0);
        return this.res;
    }

    private void getPermute(int[] nums, int index) {
        if (index == this.numsLength) {
            this.res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < this.numsLength; i++) {
            if (this.colors[i] == 0) {
                this.colors[i] = 1;
                this.path.add(nums[i]);
                this.getPermute(nums, index + 1);
                this.path.remove(this.path.size() - 1);
                this.colors[i] = 0;
            }
        }
    }
}

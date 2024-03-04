package com.learn.LC39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionOne {
    private Integer candidatesLength = 0;
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidatesLength = candidates.length;
        Arrays.sort(candidates);
        this.getCombinationSum(candidates, 0, target);
        return res;
    }

    private void getCombinationSum(int[] candidates, int index, int target) {
        if (index >= candidatesLength || target < candidates[index]) {
            if(target == 0){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = 0; i <= target / candidates[index]; i++) {
            for (int j = 0; j < i; j++) {
                path.add(candidates[index]);
            }
            this.getCombinationSum(candidates, index + 1, target - i * candidates[index]);
            for (int j = 0; j < i; j++) {
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

}

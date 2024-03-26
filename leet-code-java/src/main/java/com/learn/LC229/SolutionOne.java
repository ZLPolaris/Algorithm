package com.learn.LC229;

import java.util.ArrayList;
import java.util.List;

public class SolutionOne {
    public List<Integer> majorityElement(int[] nums) {
        int vote1 = 0;
        int vote2 = 0;
        int candidate1 = 0;
        int candidate2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && candidate1 == num) {
                vote1++;
            } else if (vote2 > 0 && candidate2 == num) {
                vote2++;
            } else if (vote1 == 0) {
                candidate1 = num;
                vote1++;
            } else if (vote2 == 0) {
                candidate2 = num;
                vote2++;
            } else {
                vote1--;
                vote2--;
            }
        }
        List<Integer> res = new ArrayList<>();
        int requiredNumber = nums.length / 3;
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        if (count1 > requiredNumber) {
            res.add(candidate1);
        }
        if (count2 > requiredNumber) {
            res.add(candidate2);
        }
        return res;
    }

}

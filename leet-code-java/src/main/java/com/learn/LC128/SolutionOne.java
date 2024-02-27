package com.learn.LC128;

import java.util.HashSet;
import java.util.List;

public class SolutionOne {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int num : nums){
            hashSet.add(num);
        }
        int res = 0;
        for(Integer data : hashSet){
            if(!hashSet.contains(data - 1)){
                int number = data;
                while (hashSet.contains(number)){
                    number++;
                }
                res = Math.max(res, number - data);
            }
        }
        return res;
    }
}

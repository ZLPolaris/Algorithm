package com.learn.LC118;

import java.util.ArrayList;
import java.util.List;

public class SolutionOne {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> oldRes = List.of(1);
        res.add(oldRes);
        for (int i = 1; i < numRows; i++) {
            List<Integer> newRes = new ArrayList<>();
            int add = 0;
            for (Integer oldRe : oldRes) {
                newRes.add(oldRe + add);
                add = oldRe;
            }
            newRes.add(1);
            res.add(newRes);
            oldRes = newRes;
        }
        return res;
    }
}

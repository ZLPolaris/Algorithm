package com.learn.LC218;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

}

public class SolutionOne {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int xEndPoint = buildings[0][0];
        int currentHeight = 0;
        int buildingsNumber = buildings.length;
        int k = 0;
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> buildings[o2][2] - buildings[o1][2]);
        return res;
    }
}

package com.learn.LC51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionOne {
    private Integer n;
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] columnFlag;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        columnFlag = new boolean[n];
        this.getSolveNQueens(0);
        List<List<String>> resStr = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".".repeat(n));
        for (List<Integer> p : res) {
            List<String> ss = new ArrayList<>();
            for (int point : p) {
                stringBuilder.setCharAt(point, 'Q');
                ss.add(stringBuilder.toString());
                stringBuilder.setCharAt(point, '.');
            }
            resStr.add(ss);
        }
        return resStr;
    }
    private void getSolveNQueens(int index) {
        if (index >= n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!columnFlag[i] && valid(index, i)) {
                columnFlag[i] = true;
                path.add(i);
                getSolveNQueens(index + 1);
                columnFlag[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean valid(int row, int column) {
        for (int i = 0; i < path.size(); i++) {
            if (path.get(i) + i == row + column || path.get(i) - i == column - row) {
                return false;
            }
        }
        return true;
    }
}

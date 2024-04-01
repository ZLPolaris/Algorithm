package com.learn.LCR085;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SolutionOne {
    private final List<String> res = new ArrayList<>();
    private final StringBuilder stringBuilder = new StringBuilder();
    private int n = 0;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        getGenerateParenthesis(0,0,0);
        return this.res;
    }

    private void getGenerateParenthesis(int index, int leftCount, int rightCount) {
        if (index == 2 * n) {
            res.add(stringBuilder.toString());
            return;
        }
        if (leftCount < n) {
            stringBuilder.append('(');
            getGenerateParenthesis(index + 1, leftCount + 1, rightCount);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (leftCount > rightCount) {
            stringBuilder.append(')');
            getGenerateParenthesis(index + 1, leftCount, rightCount + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}

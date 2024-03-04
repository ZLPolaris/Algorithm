package com.learn.LC22;

import java.util.ArrayList;
import java.util.List;

public class SolutionOne {
    private Integer n = 0;
    private Integer leftNumber = 0;
    private Integer rightNumber = 0;
    private StringBuilder stringBuilder = new StringBuilder();
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        this.leftNumber = n;
        this.rightNumber = n;
        this.n = n;
        this.getGenerateParenthesis(0);
        return res;
    }

    private void getGenerateParenthesis(int index) {
        if (index >= 2 * this.n) {
            res.add(stringBuilder.toString());
            return;
        }
        if (leftNumber > 0) {
            stringBuilder.append("(");
            leftNumber--;
            this.getGenerateParenthesis(index + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            leftNumber++;
        }
        if (leftNumber < rightNumber && rightNumber > 0) {
            stringBuilder.append(")");
            rightNumber--;
            this.getGenerateParenthesis(index + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            rightNumber++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().generateParenthesis(3));
    }
}

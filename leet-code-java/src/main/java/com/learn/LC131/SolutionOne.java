package com.learn.LC131;

import java.util.ArrayList;
import java.util.List;

public class SolutionOne {
    private Integer sLength = 0;
    private int[][] dp = null;
    private ArrayList<String> path = new ArrayList<>();
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        this.sLength = s.length();
        dp = new int[sLength][sLength];
        this.getAllPalindromicStr(s, 0);
        return res;
    }

    private void getAllPalindromicStr(String s, int index) {
        if (index >= sLength) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < sLength; i++) {
            if (isPalindromic(s, index, i) == 1) {
                path.add(s.substring(index, i + 1));
                this.getAllPalindromicStr(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private int isPalindromic(String s, int left, int right) {
        if (left >= right) {
            return 1;
        }
        if (dp[left][right] == 0) {
            dp[left][right] = s.charAt(left) == s.charAt(right) && this.isPalindromic(s, left + 1, right - 1) == 1 ? 1 : -1;
        }
        return dp[left][right];
    }
}

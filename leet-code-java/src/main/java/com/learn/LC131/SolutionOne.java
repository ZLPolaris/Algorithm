package com.learn.LC131;

import java.util.ArrayList;
import java.util.List;

public class SolutionOne {
    private Integer sLength = 0;
    private ArrayList<String> path = new ArrayList<>();
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        this.sLength = s.length();
        this.getAllPalindromicStr(s, 0);
        return res;
    }

    private void getAllPalindromicStr(String s, int index) {
        if (index >= sLength) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < sLength; i++) {
            if (isPalindromic(s, index, i)) {
                path.add(s.substring(index, i + 1));
                this.getAllPalindromicStr(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindromic(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

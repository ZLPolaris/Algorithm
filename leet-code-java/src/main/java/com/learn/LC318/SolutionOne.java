package com.learn.LC318;

import java.util.Arrays;

public class SolutionOne {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] charData = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                int bit = 1 << words[i].charAt(j) - 96;
                if ((bit & charData[i]) == 0) {
                    charData[i] += 1 << words[i].charAt(j) - 96;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((charData[i] & charData[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}

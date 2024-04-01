package com.learn.LC438;

import java.util.ArrayList;
import java.util.List;

public class SolutionTwo {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if (m < n) {
            return res;
        }
        int[] letter = new int[26];
        for (int i = 0; i < n; i++) {
            letter[s.charAt(i) - 97]++;
            letter[p.charAt(i) - 97]--;
        }
        int diff = 0;
        for (int compare : letter) {
            if (compare != 0) {
                diff++;
            }
        }
        if(diff == 0){
            res.add(0);
        }
        for (int i = n; i < m; i++) {
            int left = s.charAt(i - n) - 97;
            int right = s.charAt(i) - 97;
            if (left == right) {
                if (diff == 0) {
                    res.add(i - n + 1);
                }
                continue;
            }
            if (letter[left] == 0) {
                diff++;
            }
            letter[left]--;
            if (letter[left] == 0) {
                diff--;
            }
            if (letter[right] == 0) {
                diff++;
            }
            letter[right]++;
            if (letter[right] == 0) {
                diff--;
            }
            if (diff == 0) {
                res.add(i - n + 1);
            }
        }
        return res;
    }
}

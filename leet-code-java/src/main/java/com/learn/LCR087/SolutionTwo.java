package com.learn.LCR087;

import java.util.ArrayList;
import java.util.List;

public class SolutionTwo {
    private final static Integer K = 4;
    private final int[] path = new int[K];
    private List<String> res = new ArrayList<>();
    private int n = 0;

    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        getRestoreIpAddresses(s, 0, 0);
        return res;
    }

    private void getRestoreIpAddresses(String s, int index, int start) {
        if (index >= K || start >= n) {
            if (index >= K && start >= n) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int num : path) {
                    stringBuilder.append(num);
                    stringBuilder.append('.');
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                res.add(stringBuilder.toString());
            }
            return;
        }
        if (s.charAt(start) == '0') {
            path[index] = 0;
            getRestoreIpAddresses(s, index + 1, start + 1);
        } else {
            for (int i = start; i <= start + 2 && i < n; i++) {
                int number = Integer.parseInt(s.substring(start, i + 1));
                if (number > 0 && number <= 255) {
                    path[index] = number;
                    getRestoreIpAddresses(s, index + 1, i + 1);
                }
            }
        }
    }
}

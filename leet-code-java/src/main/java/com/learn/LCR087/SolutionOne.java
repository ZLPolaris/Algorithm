package com.learn.LCR087;

import java.util.ArrayList;
import java.util.List;

public class SolutionOne {
    private List<String> res = new ArrayList<>();
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private int n = 0;

    public List<String> restoreIpAddresses(String s) {
        this.n = s.length();
        this.getRestoreIpAddresses(s, 0, 0);
        return res;
    }

    private void getRestoreIpAddresses(String s, int index, int start) {
        if (index >= 4 || start >= n) {
            if (index >= 4 && start >= n) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Integer num : arrayList) {
                    stringBuilder.append(num);
                    stringBuilder.append('.');
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                res.add(stringBuilder.toString());
                return;
            }
        }
        if (s.charAt(start) == '0') {
            arrayList.add(0);
            getRestoreIpAddresses(s, index + 1, start + 1);
            arrayList.remove(arrayList.size() - 1);
        } else {
            for (int i = start; i <= start + 2 && i < n; i++) {
                int number = Integer.parseInt(s.substring(start, i + 1));
                if (number > 0 && number <= 255) {
                    arrayList.add(number);
                    getRestoreIpAddresses(s, index + 1, i + 1);
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
    }

}

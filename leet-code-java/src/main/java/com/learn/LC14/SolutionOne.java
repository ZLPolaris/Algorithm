package com.learn.LC14;

class Tire {
    public static final int K = 26;
}

public class SolutionOne {
    public String longestCommonPrefix(String[] strs) {
        int k = 0;
        int n = strs.length;
        while (true) {
            if (k == strs[0].length()) {
                break;
            }
            char compare = strs[0].charAt(k);
            int i = 1;
            while (i < n) {
                if(k >= strs[i].length() || strs[i].charAt(k) != compare){
                    break;
                }
                i++;
            }
            if (i < n) {
                break;
            }
            k++;
        }
        return strs[0].substring(0, k);
    }
}

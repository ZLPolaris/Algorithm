package com.learn.LC926;

public class SolutionOne {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int zeroMin = 0;
        int oneMin = 0;
        if (s.charAt(0) == '0') {
            oneMin = 1;
        } else {
            zeroMin = 1;
        }
        for (int i = 1; i < n; i++) {
            char key = s.charAt(i);
            int oneMinTmp = oneMin;
            int zeroMintmp = zeroMin;
            if(key == '0'){
                oneMin = Math.min(oneMinTmp, zeroMintmp) + 1;
            }else {
                zeroMin = zeroMintmp + 1;
                oneMin = Math.min(oneMinTmp, zeroMintmp);
            }
        }
        return Math.min(oneMin, zeroMin);
    }
}

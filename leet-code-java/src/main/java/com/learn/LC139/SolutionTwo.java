package com.learn.LC139;

import java.util.HashSet;
import java.util.List;

public class SolutionTwo {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hashSet = new HashSet<>(wordDict);
        int sLength = s.length();
        boolean[] dp = new boolean[sLength + 1];
        dp[0] = true;
        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= i; j++) {
                if (hashSet.contains(s.substring(j, i + 1)) && dp[j - 1]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[sLength];
    }
}

package com.learn.LC139;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// 复习该题目 DP解决
public class SolutionThree {
    public boolean wordBreak(String s, List<String> wordDict) {
        int sl = s.length();
        boolean[] dp = new boolean[sl];
        HashSet<String> hashSet = new HashSet<>(wordDict);
        dp[0] = hashSet.contains(s.substring(0, 1));
        for (int i = 1; i <= sl; i++) {
            if (hashSet.contains(s.substring(0, i + 1))) {
                dp[i] = true;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j] && hashSet.contains(s.substring(j + 1, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[sl - 1];
    }
}

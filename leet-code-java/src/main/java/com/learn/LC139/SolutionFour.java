package com.learn.LC139;

import java.util.List;


class Tire {
    private static final int K = 26;
    private final Tire[] children = new Tire[26];
    private boolean end = false;

    public void insert(String s) {
        Tire node = this;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Tire();
            }
            node = node.children[index];
        }
        node.end = true;
    }

    public boolean search(String s) {
        Tire node = searchPrefix(s);
        return node != null && node.end;
    }

    public Tire searchPrefix(String s) {
        Tire node = this;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}

public class SolutionFour {
    public boolean wordBreak(String s, List<String> wordDict) {
        Tire tire = new Tire();
        for (String word : wordDict) {
            tire.insert(word);
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && tire.search(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}

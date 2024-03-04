package com.learn.LC139;

import java.util.HashSet;
import java.util.List;

public class SolutionOne {
    private Integer sLength;
    private final HashSet<String> hashSet = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        hashSet.addAll(wordDict);
        sLength = s.length();
        return this.getWordBreak(s, 0);
    }

    private boolean getWordBreak(String s, int index) {
        if (index >= sLength) {
            return true;
        }
        for (int i = sLength - 1; i >= index; i--) {
            if (hashSet.contains(s.substring(index, i + 1)) && getWordBreak(s, i + 1)) {
                return true;
            }
        }
        return false;
    }

}

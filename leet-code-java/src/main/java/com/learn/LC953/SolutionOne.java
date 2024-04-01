package com.learn.LC953;

public class SolutionOne {
    public boolean isAlienSorted(String[] words, String order) {
        int ol = order.length();
        int[] letterWeight = new int[ol];
        for (int i = 0; i < ol; i++) {
            letterWeight[order.charAt(i) - 97] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (!compareWord(words[i - 1], words[i], letterWeight)) {
                return false;
            }
        }
        return true;
    }

    private boolean compareWord(String word1, String word2, int[] letterWeight) {
        int p1 = 0;
        int p2 = 0;
        int m = word1.length();
        int n = word2.length();
        while (p1 < m && p2 < n) {
            if (letterWeight[word1.charAt(p1) - 97] < letterWeight[word2.charAt(p2) - 97]) {
                return true;
            } else if (letterWeight[word1.charAt(p1) - 97] > letterWeight[word2.charAt(p2) - 97]) {
                return false;
            }
            p1++;
            p2++;
        }
        return p1 >= m;
    }
}

package com.learn.LC648;

import java.util.List;

class Tire {
    public static final int K = 26;
    private final Tire[] children = new Tire[K];
    private boolean end = false;

    public void insert(String s) {
        int n = s.length();
        Tire node = this;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Tire();
            }
            node = node.children[index];
        }
        node.end = true;
    }

    public String searchShortestPrefix(String s) {
        int n = s.length();
        Tire node = this;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (node.children[index] == null) {
                return s;
            } else {
                if (node.children[index].end) {
                    return s.substring(0, i + 1);
                }
            }
            node = node.children[index];
        }
        return s;
    }
}

public class SolutionOne {

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] sentenceWords = sentence.split(" ");
        Tire tire = new Tire();
        for (String dic : dictionary) {
            tire.insert(dic);
        }
        for (int i = 0; i < sentenceWords.length; i++) {
            sentenceWords[i] = tire.searchShortestPrefix(sentenceWords[i]);
        }
        return String.join(" ", sentenceWords);
    }
}

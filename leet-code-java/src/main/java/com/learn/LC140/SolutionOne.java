package com.learn.LC140;

import java.util.ArrayList;
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

public class SolutionOne {
    private List<String> res = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    private Tire tire = new Tire();
    private int n = 0;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.n = s.length();
        for (String word : wordDict) {
            tire.insert(word);
        }
        getWordBreak(s, 0);
        return res;
    }

    private void getWordBreak(String s, int start) {
        if (start == n) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                stringBuilder.append(path.get(i));
                if (i != path.size() - 1) {
                    stringBuilder.append(" ");
                }
            }
            res.add(stringBuilder.toString());
            return;
        }
        for (int i = start; i < n; i++) {
            String str = s.substring(start, i + 1);
            if(tire.search(str)){
                path.add(str);
                getWordBreak(s, i + 1);
                path.remove(path.size() -1);
            }
        }
    }
}


package com.learn.LC676;

import org.jetbrains.annotations.NotNull;

class Tire {
    public static final int K = 26;
    private final Tire[] children = new Tire[K];
    private boolean end = false;

    public void insert(@NotNull String s) {
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

    public static boolean search(Tire node, String s, int index) {
        int n = s.length();
        for (int i = index; i < n; i++) {
            int key = s.charAt(i) - 'a';
            if (node.children[key] == null) {
                return false;
            }
            node = node.children[key];
        }
        return node.end;
    }

    public static boolean dfs(Tire node, String s, int index) {
        if (index >= s.length()) {
            return false;
        }
        int key = s.charAt(index) - 'a';
        for (int i = 0; i < K; i++) {
            if (node.children[i] != null) {
                if (i != key && search(node.children[i], s, index + 1)) {
                    return true;
                }
                if (i == key && dfs(node.children[i], s, index + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}

class MagicDictionary {
    private final Tire tire = new Tire();

    public MagicDictionary() {
    }

    public void buildDict(String[] dictionary) {
        for (String str : dictionary) {
            tire.insert(str);
        }
    }

    public boolean search(String searchWord) {
        return Tire.dfs(tire, searchWord, 0);
    }
}

public class SolutionOne {
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(magicDictionary.search("hhllo"));
    }
}

package com.learn.LC211;

class Tire {
    public static final int K = 26;
    private final Tire[] children = new Tire[K];
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
        Tire node = this;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '.') {
                for (int j = 0; j < K; j++) {
                    if (node.children[j] != null && node.children[j].search(s.substring(i + 1))) {
                        return true;
                    }
                }
                return false;
            } else {
                int index = s.charAt(i) - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
        }
        return node.end;
    }
}

class WordDictionary {
    private final Tire tire = new Tire();

    public WordDictionary() {
    }

    public void addWord(String word) {
        tire.insert(word);
    }

    public boolean search(String word) {
        return tire.search(word);
    }
}

public class SolutionOne {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("."));
    }
}

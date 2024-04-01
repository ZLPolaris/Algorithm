package com.learn.LC208;

class Trie {
    private static final Integer K = 26;
    private final Trie[] children = new Trie[K];
    private boolean endFlag = false;

    public Trie() {
    }

    public void insert(String word) {
        Trie node = this;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.endFlag = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.endFlag;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        int n = prefix.length();
        for (int i = 0; i < n; i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}

public class SolutionTwo {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ab");
        System.out.println(trie.search("a"));
        System.out.println(trie.search("ab"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }
}

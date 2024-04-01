package com.learn.LC208;


class Trie1 {
    private Trie1[] children = new Trie1[26];
    private boolean end = false;

    public Trie1() {
    }

    public void insert(String word) {
        if (word.isEmpty()) {
            end = true;
            return;
        }
        char first = word.charAt(0);
        if (children[first - 97] == null) {
            children[first - 97] = new Trie1();
        }
        children[first - 97].insert(word.substring(1));
    }

    public boolean search(String word) {
        if (word.isEmpty()) {
            return end;
        }
        char first = word.charAt(0);
        if (children[first - 97] == null) {
            return false;
        }
        return children[first - 97].search(word.substring(1));
    }

    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) {
            return true;
        }
        char first = prefix.charAt(0);
        if (children[first - 97] == null) {
            return false;
        }
        return children[first - 97].startsWith(prefix.substring(1));
    }
}

public class SolutionOne {
    public static void main(String[] args) {
        Trie1 trie = new Trie1();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
                System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }
}

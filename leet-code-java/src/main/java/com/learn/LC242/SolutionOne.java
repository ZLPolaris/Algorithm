package com.learn.LC242;

// 有点复杂了，没有考虑到两个字符串长度相同，所以letter出现负数就一定false，不出现就位true
public class SolutionOne {
    public boolean isAnagram(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        int[] letter = new int[26];
        int diff = 0;
        for (int i = 0; i < sl; i++) {
            int key = s.charAt(i) - 97;
            if (letter[key] == 0) {
                diff++;
            }
            letter[key]++;
        }
        for (int i = 0; i < tl; i++) {
            int key = t.charAt(i) - 97;
            if (letter[key] == 0) {
                diff++;
            }
            letter[key]--;
            if (letter[key] == 0) {
                diff--;
            }
        }
        return diff == 0;
    }
}

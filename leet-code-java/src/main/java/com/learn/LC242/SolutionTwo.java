package com.learn.LC242;

public class SolutionTwo {
    public boolean isAnagram(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if(sl != tl){
            return false;
        }
        int[] letter = new int[26];
        for (int i = 0; i < sl; i++) {
            int key = s.charAt(i) - 97;
            letter[key]++;
        }
        for (int i = 0; i < tl; i++) {
            int key = t.charAt(i) - 97;
            letter[key]--;
            if (letter[key] < 0) {
                return false;
            }
        }
        return true;
    }
}

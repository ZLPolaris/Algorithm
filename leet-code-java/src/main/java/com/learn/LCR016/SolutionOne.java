package com.learn.LCR016;

import java.util.HashSet;

public class SolutionOne {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int n = s.length();
        int right = 0;
        int res = 0;
        HashSet<Character> hashSet = new HashSet<>();
        while (right < n) {
            char key = s.charAt(right);
            if (hashSet.contains(key)) {
                res = Math.max(res, right - left);
                while (hashSet.contains(key)) {
                    hashSet.remove(s.charAt(left));
                    left++;
                }
            }
            hashSet.add(key);
            right++;
        }
        res = Math.max(res, right - left);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().lengthOfLongestSubstring("abcabcbb"));
    }
}

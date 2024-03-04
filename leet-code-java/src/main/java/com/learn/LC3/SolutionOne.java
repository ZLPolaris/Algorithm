package com.learn.LC3;

import java.util.HashMap;

public class SolutionOne {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = 0;
        int sLength = s.length();
        int res = 0;
        int right = left;
        while (right < sLength) {
            while (right < sLength && hashMap.getOrDefault(s.charAt(right), -1) < left) {
                hashMap.put(s.charAt(right), right);
                right++;
            }
            res = Math.max(res, right - left);
            if (right < sLength) {
                left = hashMap.get(s.charAt(right)) + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().lengthOfLongestSubstring("pwwkew"));
    }
}

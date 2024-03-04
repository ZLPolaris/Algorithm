package com.learn.LC438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolutionOne {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            Character key = p.charAt(i);
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int left = 0, right = left;
        int sLength = s.length();
        int pLength = p.length();
        while (right < sLength) {
            Character key = s.charAt(right);
            int keyNum = hashMap.getOrDefault(key, 0);
            if (keyNum == 0) {
                if (hashMap.containsKey(key)) {
                    hashMap.put(s.charAt(left), hashMap.getOrDefault(s.charAt(left), 0) + 1);
                    left++;
                } else {
                    while (left < right) {
                        hashMap.put(s.charAt(left), hashMap.getOrDefault(s.charAt(left), 0) + 1);
                        left++;
                    }
                    left++;
                    right++;
                }
            } else {
                keyNum--;
                hashMap.put(key, keyNum);
                if (right - left + 1 == pLength) {
                    res.add(left);
                    hashMap.put(s.charAt(left), hashMap.getOrDefault(s.charAt(left), 0) + 1);
                    left++;
                }
                right++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().findAnagrams("abab", "ab"));
    }
}

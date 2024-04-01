package com.learn.LCR033;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolutionOne {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 97]++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    stringBuilder.append(count[i]);
                    stringBuilder.append((char) (i + 97));
                }
            }
            String key = stringBuilder.toString();
            List<String> al = hashMap.getOrDefault(key, new ArrayList<>());
            al.add(str);
            hashMap.put(key, al);
        }
        return new ArrayList<>(hashMap.values());
    }
}

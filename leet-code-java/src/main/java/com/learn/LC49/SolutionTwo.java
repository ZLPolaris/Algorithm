package com.learn.LC49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolutionTwo {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if(counts[i] > 0){
                    stringBuilder.append((char) ('a' + i));
                    stringBuilder.append(counts[i]);
                }
            }
            String key = stringBuilder.toString();
            ArrayList<String> al =  hashMap.getOrDefault(key, new ArrayList<>());
            al.add(str);
            hashMap.put(key, al);
        }
        return new ArrayList<>(hashMap.values());
    }
}

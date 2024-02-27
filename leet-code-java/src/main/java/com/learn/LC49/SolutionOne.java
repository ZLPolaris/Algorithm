package com.learn.LC49;

import java.util.*;

public class SolutionOne {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> data = new HashMap<>();
        for (String str : strs) {
            String s = this.sortString(str);
            if (!data.containsKey(s)) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(str);
                data.put(s, arrayList);
            } else {
                data.get(s).add(str);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String str : data.keySet()) {
            res.add(data.get(str));
        }
        return res;
    }

    public String sortString(String str) {
        int strLength = str.length();
        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strLength; i++) {
            arrayList.add(str.substring(i, i + 1));
        }
        arrayList.sort(String::compareTo);
        for (String s : arrayList) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}

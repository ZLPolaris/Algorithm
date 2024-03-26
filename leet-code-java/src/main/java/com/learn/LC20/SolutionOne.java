package com.learn.LC20;

import java.util.ArrayList;

public class SolutionOne {
    public boolean isValid(String s) {
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '}') {
                if (arrayList.isEmpty() || arrayList.get(arrayList.size() - 1) != '{') {
                    return false;
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            } else if (s.charAt(i) == ']') {
                if (arrayList.isEmpty() || arrayList.get(arrayList.size() - 1) != '[') {
                    return false;
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            } else if (s.charAt(i) == ')') {
                if (arrayList.isEmpty() || arrayList.get(arrayList.size() - 1) != '(') {
                    return false;
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            } else {
                arrayList.add(s.charAt(i));
            }
        }
        return arrayList.isEmpty();
    }
}

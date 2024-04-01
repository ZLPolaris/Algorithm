package com.learn.LCR017;

import java.util.HashMap;

public class SolutionOne {
    public String minWindow(String s, String t) {
        int sL = s.length();
        int tL = t.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < tL; i++) {
            hashMap.put(t.charAt(i), hashMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count = tL;
        int left = 0;
        int right = 0;
        String res = "";
        while (right < sL) {
            char key = s.charAt(right);
            if (hashMap.containsKey(key)) {
                int num = hashMap.get(key);
                if (num > 0) {
                    count--;
                }
                hashMap.put(key, num - 1);
                if (count == 0) {
                    while (count == 0) {
                        char leftKey = s.charAt(left);
                        if (hashMap.containsKey(leftKey)) {
                            int num1 = hashMap.get(leftKey);
                            if (num1 == 0) {
                                count++;
                            }
                            hashMap.put(leftKey, num1 + 1);
                        }
                        left++;
                    }
                    if (res.isEmpty() || res.length() > right - left + 2) {
                        res = s.substring(left - 1, right + 1);
                    }
                }
            }
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().minWindow("a", "aa"));
    }
}

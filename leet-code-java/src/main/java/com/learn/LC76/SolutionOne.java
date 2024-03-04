package com.learn.LC76;

import java.util.HashMap;

public class SolutionOne {
    public String minWindow(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character key = t.charAt(i);
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
        }
        int left = 0;
        int right = left;
        int matchNumber = 0;
        int[] res = new int[2];
        int smallest = Integer.MAX_VALUE;
        while (left < sLength - tLength + 1) {
            while (right < sLength && matchNumber < tLength) {
                if (hashMap.containsKey(s.charAt(right))) {
                    int num = hashMap.get(s.charAt(right));
                    if (num > 0) {
                        matchNumber++;
                    }
                    hashMap.put(s.charAt(right), --num);
                }
                right++;
            }
            System.out.println(left);
            System.out.println(right);
            System.out.println("----");
            if (matchNumber == tLength && right - left < smallest) {
                smallest = right - left;
                res[0] = left;
                res[1] = right;
            }
            Character key = s.charAt(left);
            if (hashMap.containsKey(key)) {
                int num = hashMap.get(key);
                num++;
                hashMap.put(key, num);
                if (num > 0) {
                    matchNumber--;
                }
            }
            left++;
        }
        return s.substring(res[0], res[1]);
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().minWindow("a", "aa"));
    }
}

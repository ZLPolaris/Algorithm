package com.learn.LC567;

import java.util.Arrays;

public class SolutionTwo {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int[] letterCompare = new int[26];
        if (s1Len > s2Len) {
            return false;
        }
        for (int i = 0; i < s1Len; i++) {
            letterCompare[s1.charAt(i) - 97]--;
            letterCompare[s2.charAt(i) - 97]++;
        }
        int diff = 0;
        for (int compare : letterCompare) {
            if (compare != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = s1Len; i < s2Len; i++) {
            int left = s2.charAt(i - s1Len) - 97;
            int right = s2.charAt(i) - 97;
            if (left == right) {
                continue;
            }
            if (letterCompare[left] == 0) {
                diff++;
            }
            letterCompare[left]--;
            if (letterCompare[left] == 0) {
                diff--;
            }
            if (letterCompare[right] == 0) {
                diff++;
            }
            letterCompare[right]++;
            if (letterCompare[right] == 0) {
                diff--;
            }

            System.out.println(i);
            System.out.println(diff);
            System.out.println(Arrays.toString(letterCompare));
            System.out.println("-----------");
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }
}

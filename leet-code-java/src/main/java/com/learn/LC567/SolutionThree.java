package com.learn.LC567;

public class SolutionThree {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int left = 0;
        int right = 0;
        int[] letter = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letter[s1.charAt(i) - 97]++;
        }
        while (right < s2Len) {
            letter[s2.charAt(right) - 97]--;
            while (letter[s2.charAt(right) - 97] < 0) {
                letter[s2.charAt(left) - 97]++;
                left++;
            }
            if (right - left + 1 == s1Len) {
                return true;
            }
            right++;
        }
        return false;
    }
}

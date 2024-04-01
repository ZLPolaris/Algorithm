package com.learn.LC567;

public class SolutionOne {
    public boolean checkInclusion(String s1, String s2) {
        boolean res = false;
        int s1Len = s1.length();
        int s2Len = s2.length();
        int[] letterNumber = new int[26];
        for (int i = 0; i < s1Len; i++) {
            letterNumber[s1.charAt(i) - 97]++;
        }
        int left = 0;
        int count = 0;
        int[] letterNumberCopy = letterNumber.clone();
        while (left < s2Len - s1Len + 1) {
            int right = left;
            while (right < s2Len && letterNumberCopy[s2.charAt(right) - 97] != 0) {
                letterNumberCopy[s2.charAt(right++) - 97]--;
                count++;
            }
            if (count == s1Len) {
                System.out.println(left);
                res = true;
                break;
            }
            if (right >= s2Len || letterNumber[s2.charAt(right) - 97] != 0) {
                left++;
            } else {
                left = right + 1;
            }
            count = 0;
            letterNumberCopy = letterNumber.clone();
        }
        return res;
    }
}

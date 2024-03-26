package com.learn.LC32;

public class SolutionOne {
    public int longestValidParentheses(String s) {
        int sLength = s.length();
        int left = 0;
        int right = left;
        int longest = 0;
        while (left < sLength) {
            int leftBracket = 0;
            int rightBracket = 0;
            while (leftBracket >= rightBracket && right < sLength) {
                if (leftBracket == rightBracket) {
                    longest = Math.max(longest, right - left);
                }
                if (s.charAt(right) == '(') {
                    leftBracket++;
                } else {
                    rightBracket++;
                }
                right++;
            }
            if (leftBracket < rightBracket) {
                longest = Math.max(longest, right - left - 1);
                left = right;
            } else if (leftBracket == rightBracket) {
                longest = Math.max(longest, right - left);
                left = right;
            } else {
                left++;
                right = left;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().longestValidParentheses("(())("));
    }
}

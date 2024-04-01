package com.learn.LCR018;

public class SolutionOne {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
                right--;
            }
            if (!compareIgnoreUpper(s.charAt(left++), s.charAt(right--))) {
                return false;
            }
        }
        return true;
    }

    private boolean compareIgnoreUpper(char a, char b) {
        if (a >= 97 && a <= 123) {
            a = (char) (a - 32);
        }
        if (b >= 97 && b <= 123) {
            b = (char) (b - 32);
        }
        return a == b;
    }

    public static void main(String[] args) {
        System.out.println('P' - 0);
        System.out.println('0' - 0);
        System.out.println(new SolutionOne().isPalindrome("0P"));
    }
}

package com.learn.LC67;

public class SolutionOne {
    public String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int point1 = aLength - 1;
        int point2 = bLength - 1;
        int process = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (point1 >= 0 && point2 >= 0) {
            int bit1 = a.charAt(point1) - 48;
            int bit2 = b.charAt(point2) - 48;
            int sum = bit1 + bit2 + process;
            stringBuilder.insert(0, (char) (sum % 2 + 48));
            process = sum / 2;
            point1--;
            point2--;
        }
        while (point1 >= 0) {
            int bit1 = a.charAt(point1) - 48;
            int sum = bit1 + process;
            stringBuilder.insert(0, (char) (sum % 2 + 48));
            process = sum / 2;
            point1--;
        }
        while (point2 >= 0) {
            int bit2 = b.charAt(point2) - 48;
            int sum = bit2 + process;
            stringBuilder.insert(0, (char) (sum % 2 + 48));
            process = sum / 2;
            point2--;
        }
        if (process != 0) {
            stringBuilder.insert(0, '1');
        }
        return stringBuilder.toString();
    }
}

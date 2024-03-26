package com.learn.LC394;

public class SolutionTwo {
    public String decodeString(String s) {
        return getString(s, 0, s.length() - 1);
    }

    public String getString(String s, int left, int right) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = left;
        while (i <= right) {
            while (i <= right && Character.isLetter(s.charAt(i))) {
                stringBuilder.append(s.charAt(i));
                i++;
            }
            StringBuilder numberBuilder = new StringBuilder();
            while (i <= right && Character.isDigit(s.charAt(i))) {
                numberBuilder.append(s.charAt(i));
                i++;
            }
            if (!numberBuilder.isEmpty()) {
                int number = Integer.parseInt(numberBuilder.toString());
                int iLeft = ++i;
                int leftBracket = 1;
                int rightBracket = 0;
                while (i <= right && rightBracket < leftBracket) {
                    if (s.charAt(i) == '[') {
                        leftBracket++;
                    } else if (s.charAt(i) == ']') {
                        rightBracket++;
                    }
                    i++;
                }
                stringBuilder.append(this.getString(s, iLeft, i - 2).repeat(number));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SolutionTwo().decodeString("abc3[cd]xyz"));
    }
}

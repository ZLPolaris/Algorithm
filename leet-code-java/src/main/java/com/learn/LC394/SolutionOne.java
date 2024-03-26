package com.learn.LC394;

import java.util.Deque;
import java.util.LinkedList;


public class SolutionOne {
    public String decodeString(String s) {
        int sLength = s.length();
        Deque<Integer> numberStack = new LinkedList<>();
        Deque<String> charStack = new LinkedList<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) <= 57 && s.charAt(i) >= 48) {
                int begin = i;
                while (i < sLength && s.charAt(i) <= 57 && s.charAt(i) >= 48) {
                    i++;
                }
                numberStack.push(Integer.valueOf(s.substring(begin, i)));
            } else {
                if (s.charAt(i) == '[') {
                    charStack.push("[");
                    i++;
                } else if (s.charAt(i) == ']') {
                    int number = numberStack.pop();
                    StringBuilder stringBuilder = new StringBuilder();
                    while (!"[".equals(charStack.peek())) {
                        stringBuilder.insert(0, charStack.peek());
                        charStack.pop();

                    }
                    String peek = stringBuilder.toString().repeat(number);
                    charStack.pop();
                    charStack.push(peek);
                    i++;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    while (i < sLength && s.charAt(i) != '[' && s.charAt(i) != ']' && Character.isAlphabetic(s.charAt(i))) {
                        stringBuilder.append(s.charAt(i));
                        i++;
                    }
                    charStack.push(stringBuilder.toString());
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!charStack.isEmpty()) {
            stringBuilder.append(charStack.pollLast());
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        System.out.println(new SolutionOne().decodeString("abc3[cd]xyz"));
    }
}

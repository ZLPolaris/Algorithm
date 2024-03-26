package com.learn.LC20;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class SolutionTwo {
   public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (hashMap.containsKey(key)){
                if(stack.isEmpty() || stack.peek() != hashMap.get(key)){
                    return false;
                }else {
                    stack.pop();
                }
            }else {
               stack.push(key);
            }
        }
        return stack.isEmpty();
    }
}

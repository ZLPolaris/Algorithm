package com.learn.LC17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolutionOne {
    private Integer digitLength;
    private HashMap<Character, char[]> hashMap = new HashMap<>();
    private List<String> res = new ArrayList<>();
    private StringBuilder stringBuilder = new StringBuilder();

    {
        hashMap.put('2', new char[]{'a', 'b', 'c'});
        hashMap.put('3', new char[]{'d', 'e', 'f'});
        hashMap.put('4', new char[]{'g', 'h', 'i'});
        hashMap.put('5', new char[]{'j', 'k', 'l'});
        hashMap.put('6', new char[]{'m', 'n', 'o'});
        hashMap.put('7', new char[]{'p', 'q', 'r', 's'});
        hashMap.put('8', new char[]{'t', 'u', 'v'});
        hashMap.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        this.digitLength = digits.length();
        if(digitLength == 0){
            return res;
        }
        this.getLetterCombinations(digits, 0);
        return this.res;
    }

    private void getLetterCombinations(String digits, int index){
        if(index == digitLength){
            res.add(stringBuilder.toString());
            return;
        }
        char[] letter = hashMap.get(digits.charAt(index));
        for (char c : letter) {
            stringBuilder.append(c);
            this.getLetterCombinations(digits, index + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}

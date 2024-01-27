package com.learn.LC397;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public Map<Integer, Integer> map = new HashMap<>();

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (!map.containsKey(n)) {
            if ((n & 1) == 0) {
                map.put(n, integerReplacement(n / 2) + 1);
            } else {
                map.put(n, Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)) + 2);
            }
        }
        return map.get(n);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().integerReplacement(3));
    }
}

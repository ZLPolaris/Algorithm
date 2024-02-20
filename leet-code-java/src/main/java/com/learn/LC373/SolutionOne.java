package com.learn.LC373;

import java.util.ArrayList;
import java.util.List;

public class SolutionOne {
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(nums1[0], nums2[0]));
        int oneLength = nums1.length;
        int twoLength = nums2.length;
        k--;
        int oneBegin = 0, oneEnd = 1, twoBegin = 0, twoEnd = 1;
        while (k > 0 && oneBegin < oneLength && twoBegin < twoLength) {
            int num1 = nums1[oneBegin] + nums2[twoEnd];
            int num2 = nums1[oneEnd] + nums2[twoBegin];
            if (num1 <= num2) {
                res.add(List.of(nums1[oneBegin], nums2[twoEnd]));
                twoEnd++;
                if (twoEnd >= twoLength) {
                    twoEnd = 0;
                    oneBegin++;
                }
            } else {
                res.add(List.of(nums1[oneEnd], nums2[twoBegin]));
                oneEnd++;
                if (oneEnd >= oneLength) {
                    oneEnd = 0;
                    twoBegin++;
                }
            }
            k--;
        }
        while (k > 0 && oneBegin < oneLength) {
            res.add(List.of(nums1[oneBegin], nums2[twoEnd]));
            twoEnd++;
            if (twoEnd >= twoLength) {
                twoEnd = 0;
                oneBegin++;
            }
            k--;
        }
        while (k > 0 && twoBegin < twoLength) {
            res.add(List.of(nums1[oneEnd], nums2[twoBegin]));
            oneEnd++;
            if (oneEnd >= oneLength) {
                oneEnd = 0;
                twoBegin++;
            }
            k--;
        }
        return res;
    }
}
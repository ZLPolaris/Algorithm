package com.learn.MST10_05;

public class SolutionOne {
    public int findString(String[] words, String s) {
        int left = 0;
        int right = words.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            System.out.println(mid);
            if (words[mid].isEmpty()) {
                if (!words[left].isEmpty() && !words[right].isEmpty()) {
                    int leftRes = s.compareTo(words[left]);
                    int rightRes = s.compareTo(words[right]);
                    if (leftRes == 0) {
                        return left;
                    } else if (rightRes == 0) {
                        return right;
                    } else if (leftRes < 0 || rightRes > 0) {
                        return -1;
                    } else {
                        left++;
                        right--;
                    }
                }else {
                    if(words[left].isEmpty()){
                        left++;
                    }
                    if(words[right].isEmpty()){
                        right--;
                    }
                }
            } else {
                int res = words[mid].compareTo(s);
                if (res == 0) {
                    return mid;
                } else if (res < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}

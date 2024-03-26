package com.learn.LC4;

public class SolutionOne {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (((n1 + n2) & 1) == 1) {
            return findKSortedArrays(nums1, nums2, Math.ceilDiv(n1 + n2, 2));
        } else {
            return (findKSortedArrays(nums1, nums2, Math.ceilDiv(n1 + n2, 2)) + findKSortedArrays(nums1, nums2, Math.ceilDiv(n1 + n2, 2) + 1)) / 2.0;
        }
    }

    private int findKSortedArrays(int[] nums1, int[] nums2, int k) {
        int left1 = 0, n1 = nums1.length - 1;
        int left2 = 0, n2 = nums2.length - 1;
        while (left1 <= n1 && left2 <= n2 && k != 1) {
            int pos = k / 2;
            int mid1Index = Math.min(left1 + pos - 1, n1);
            int mid2Index = Math.min(left2 + pos - 1, n2);
            if (nums1[mid1Index] >= nums2[mid2Index]) {
                k -= mid2Index - left2 + 1;
                left2 = mid2Index + 1;
            } else {
                k -= mid1Index - left1 + 1;
                left1 = mid1Index + 1;
            }
        }
        if (left1 <= n1 && left2 <= n2 && k == 1) {
            return Math.min(nums1[left1], nums2[left2]);
        }
        if (left1 <= n1) {
            return nums1[left1 + k - 1];
        } else {
            return nums2[left2 + k - 1];
        }
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOne().findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4,5,6}));
    }
}

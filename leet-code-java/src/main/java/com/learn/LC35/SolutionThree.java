package com.learn.LC35;

public class SolutionThree {
    // 换一个思路，使用二分的思想求刚好大于等于目标值元素的位置，也就是说排除小于等于这个元素的全部排除。
    public int searchInsert(int[] nums, int target) {
        int left = 0;      // 左边的元素都比target小
        int right = nums.length; // 右边的包含自身都大于等于target
        while (left < right) { // 明确判断范围
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}

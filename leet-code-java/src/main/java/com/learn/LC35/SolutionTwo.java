package com.learn.LC35;

public class SolutionTwo {

    // 明确二位题目查找目标，目标值的索引或者顺序插入位置（刚好大于它的第一个元素位置，或者左边元素都比它小的位置）
    public int searchInsert(int[] nums, int target) {
        // 2。明确左右指针的范围及其意义
        int left = 0; // 左边不包含本身的元素都比它小
        int right = nums.length - 1; // 右边不包含本身的元素都比它大
        while (left <= right){    //5.明确循环的含义，根据left和right含义
            int mid = left + ((right - left) >> 1); // 3.明确mid求法
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){  // 4.用淘汰的思想
                right = mid - 1; // mid及其右边的都比target大，全部淘汰
            }else {
                left = mid + 1; // mid及其左边的都比target小，全部淘汰
            }
        }
        return left;
    }
}

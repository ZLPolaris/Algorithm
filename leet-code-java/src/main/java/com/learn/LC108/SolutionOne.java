package com.learn.LC108;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SolutionOne {
    public TreeNode sortedArrayToBST(int[] nums) {
        return this.getSortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode getSortedArrayToBST(int[] nums, int left, int right) {
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getSortedArrayToBST(nums, left, mid - 1);
        root.right = getSortedArrayToBST(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        System.out.println((2 + 8) >> 1);
    }
}

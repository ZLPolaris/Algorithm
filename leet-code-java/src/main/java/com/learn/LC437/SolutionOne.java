package com.learn.LC437;

import java.util.ArrayList;

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
    private Integer res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        this.getPathSum(root, new ArrayList<>(), targetSum);
        return this.res;
    }

    public void getPathSum(TreeNode node, ArrayList<Long> arrayList, int targetNum) {
        if (node == null) {
            return;
        }
        ArrayList<Long> newArrayList = new ArrayList<>();
        for (Long num : arrayList) {
            long remain = num - node.val;
            if (remain == 0) {
                this.res++;
            }
            newArrayList.add(remain);
        }
        if (node.val == targetNum) {
            this.res++;
        }
        newArrayList.add((long)(targetNum - node.val));
        this.getPathSum(node.left, newArrayList, targetNum);
        this.getPathSum(node.right, newArrayList, targetNum);
    }
}

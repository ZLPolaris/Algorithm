package com.learn.LC543;

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
    private int biggest = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        getDiameterOfBinaryTree(root);
        return this.biggest - 1;
    }

    public int getDiameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int deep1 = getDiameterOfBinaryTree(root.left);
        int deep2 = getDiameterOfBinaryTree(root.right);
        biggest = Math.max(biggest, deep2 + deep1 + 1);
        return Math.max(deep1, deep2) + 1;
    }
}

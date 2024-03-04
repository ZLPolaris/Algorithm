package com.learn.LC124;

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
    private int biggest = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return this.biggest;
    }

    private int getMaxPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMax = this.getMaxPathSum(node.left);
        int rightMax = this.getMaxPathSum(node.right);
        int theMax = Math.max(leftMax, rightMax);
        int more = Math.max(theMax + node.val, node.val);
        this.biggest = Math.max(biggest, Math.max(more, leftMax + rightMax + node.val));
        return Math.max(0, more);
    }
}

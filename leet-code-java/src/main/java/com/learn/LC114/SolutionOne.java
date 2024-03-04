package com.learn.LC114;

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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        getFlatten(root);
    }

    public TreeNode getFlatten(TreeNode node) {
        TreeNode end = node;
        if (node.left != null) {
            end = getFlatten(node.left);
        }
        if (node.right != null) {
            end.right = node.right;
            end = getFlatten(node.right);
        }
        node.right = node.left != null ? node.left : node.right;
        node.left = null;
        return end;
    }
}

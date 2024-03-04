package com.learn.LC98;

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
    public boolean isValidBST(TreeNode root) {
        TreeNode p = root;
        Integer preValue = null;
        while (p != null) {
            if (p.left != null) {
                TreeNode process = p.left;
                while (process.right != null && process.right != p) {
                    process = process.right;
                }
                if (process.right == null) {
                    process.right = p;
                    p = p.left;
                } else {
                    if (preValue != null && p.val <= preValue) {
                        return false;
                    }
                    preValue = p.val;
                    p = p.right;
                }
            } else {
                if (preValue != null && p.val <= preValue) {
                    return false;
                }
                preValue = p.val;
                p = p.right;
            }
        }
        return true;
    }
}



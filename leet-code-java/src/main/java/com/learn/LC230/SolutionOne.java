package com.learn.LC230;

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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode p = root;
        while (p != null) {
            if (p.left != null) {
                TreeNode pt = p.left;
                while (pt.right != null && pt.right != p) {
                    pt = pt.right;
                }
                if (pt.right == null) {
                    pt.right = p;
                    p = p.left;
                } else {
                    k--;
                    if (k == 0) {
                        return p.val;
                    }
                    p = p.right;
                }
            } else {
                k--;
                if (k == 0) {
                    return p.val;
                }
                p = p.right;
            }
        }
        return -1;
    }
}

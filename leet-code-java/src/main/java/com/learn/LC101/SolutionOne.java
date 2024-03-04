package com.learn.LC101;

import javax.xml.stream.FactoryConfigurationError;

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
    public boolean isSymmetric(TreeNode root) {
        return this.isSymmetricTree(root.left, root.right);
    }

    public boolean isSymmetricTree(TreeNode one, TreeNode two) {
        if(one == null || two == null){
            return one == null && two == null;
        }
        if (one.val != two.val) {
            return false;
        }
        return isSymmetricTree(one.left, two.right) && isSymmetricTree(one.right, two.left);
    }
}

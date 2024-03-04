package com.learn.LC236;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class SolutionOne {
    private TreeNode treeNode = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.findLowestCommonAncestor(root, p, q);
        return this.treeNode;
    }

    public int findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (treeNode != null) {
            return -1;
        }
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val == p.val || root.val == q.val) {
            count++;
        }
        count += this.findLowestCommonAncestor(root.left, p, q);
        count += this.findLowestCommonAncestor(root.right, p, q);
        if (count >= 2 && treeNode == null) {
            treeNode = root;
        }
        return count;
    }
}

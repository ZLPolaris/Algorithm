package com.learn.LC105;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return this.buildSpecificTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public int indexOf(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildSpecificTree(int[] preorder, int[] inorder, int pos, int left, int right) {
        if(left > right){
            return null;
        }
        if(left == right){
            return new TreeNode(preorder[pos]);
        }
        TreeNode root = new TreeNode(preorder[pos]);
        int rootIndex = indexOf(inorder, preorder[pos]);
        int leftLength = rootIndex - left;
        root.left = buildSpecificTree(preorder, inorder, pos + 1, left, rootIndex - 1);
        root.right = buildSpecificTree(preorder, inorder, pos + leftLength + 1, rootIndex + 1, right);
        return root;
    }
}

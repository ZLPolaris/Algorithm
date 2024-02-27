package com.learn.LC94;

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode p = root;
        while (p != null){
            if(p.left != null){
                TreeNode leftChild = p.left;
                while (leftChild.right != null && leftChild.right != p){
                    leftChild = leftChild.right;
                }
                if(leftChild.right == null){
                    leftChild.right = p;
                    p = p.left;
                }else {
                    res.add(p.val);
                    p = p.right;
                }
            }else {
                res.add(p.val);
                p = p.right;
            }
        }
        return res;
    }
}

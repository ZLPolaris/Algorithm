package com.learn.LC199;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode right = null;
            while (size > 0) {
                right = queue.poll();
                size--;
                if(right.left != null){
                    queue.offer(right.left);
                }
                if(right.right != null){
                    queue.offer(right.right);
                }
            }
            res.add(right.val);
        }
        return res;
    }
}

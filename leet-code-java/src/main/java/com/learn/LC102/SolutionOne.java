package com.learn.LC102;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;

        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode peek = queue.poll();
                row.add(peek.val);
                if (peek.left != null) {
                    queue.offer(peek.left);
                }
                if (peek.right != null) {
                    queue.offer(peek.right);
                }
            }
            res.add(row);
        }
        return res;
    }
}

# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if root is None:
            return False
        s = [(root, root.val)]
        while s:
            node, path = s.pop()
            if node.left is None and node.right is None and path == targetSum:
                return True
            if node.left:
                s.append((node.left, path + node.left.val))
                pass
            if node.right:
                s.append((node.right, path + node.right.val))
                pass
            pass
        return False

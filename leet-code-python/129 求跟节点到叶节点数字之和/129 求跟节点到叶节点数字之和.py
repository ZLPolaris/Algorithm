# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        q = [(root, root.val)]
        count = 0
        while q:
            ele, vals = q.pop(0)
            if ele.left is None and ele.right is None:
                count += vals
                continue
                pass
            if ele.left:
                q.append((ele.left, vals * 10 + ele.left.val))
                pass
            if ele.right:
                q.append((ele.right, vals * 10 + ele.right.val))
                pass
            pass
        return count
    pass



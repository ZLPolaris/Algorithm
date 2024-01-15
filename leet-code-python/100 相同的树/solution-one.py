# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        q1 = list()
        q2 = list()
        if p is not None:
            q1.append(p)
            pass
        if q is not None:
            q2.append(q)
            pass
        while len(q1) > 0 and len(q2) > 0:
            front1 = q1.pop(0)
            front2 = q2.pop(0)
            if front1.val != front2.val:
                return False
            if front1.left is None and front2.left is not None or front1.left is not None and front2.left is None:
                return False
            if front1.right is None and front2.right is not None or front1.right is not None and front2.right is None:
                return False
            if front1.left:
                q1.append(front1.left)
                pass
            if front1.right:
                q1.append(front1.right)
                pass
            if front2.left:
                q2.append(front2.left)
                pass
            if front2.right:
                q2.append(front2.right)
                pass
            pass
        pass
        if len(q1) > 0 or len(q2) > 0:
            return False
        return True
    pass

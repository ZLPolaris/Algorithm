# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def getSymmetric(left: Optional[TreeNode], right: Optional[TreeNode]) -> bool:
            q = list()
            q.append(left)
            q.append(right)
            while len(q) > 0:
                front1 = q.pop(0)
                front2 = q.pop(0)
                if front1 is None and front2 is None:
                    continue
                    pass
                if (front1 is None or front2 is None) or front1.val != front2.val:
                    return False
                q.append(front1.left)
                q.append(front2.right)
                q.append(front1.right)
                q.append(front2.left)
                pass
            return True
            pass

        return getSymmetric(root.left, root.right)

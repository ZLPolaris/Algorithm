# Definition for a binary tree node.
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass

    pass


class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        s = []
        res = []

        def appendLeftNode(node: Optional[TreeNode]):
            while node:
                s.append(node)
                node = node.left
                pass

        appendLeftNode(root)
        while s:
            ele = s.pop()
            res.append(ele.val)
            appendLeftNode(ele.right)
            pass
        return res
        pass

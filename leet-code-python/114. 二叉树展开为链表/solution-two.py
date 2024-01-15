# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    preNode = None

    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """

        def MLR(node: Optional[TreeNode]):
            if node:
                leftNode = node.left
                rightNode = node.right
                if self.preNode:
                    self.preNode.left = None
                    self.preNode.right = node
                    pass
                self.preNode = node
                MLR(leftNode)
                MLR(rightNode)
                pass
            pass

        MLR(root)


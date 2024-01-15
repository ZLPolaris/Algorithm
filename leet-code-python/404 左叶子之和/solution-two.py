# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    n = 0

    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        def getSumOfLeftLeaves(node: Optional[TreeNode]):
            if node.left:
                if node.left.left is None and node.left.right is None:
                    self.n += 1
                    pass
                else:
                    getSumOfLeftLeaves(node.left)
                    pass
                pass
            if node.right:
                getSumOfLeftLeaves(node.right)
                pass
            pass
        getSumOfLeftLeaves(root)
        return self.n

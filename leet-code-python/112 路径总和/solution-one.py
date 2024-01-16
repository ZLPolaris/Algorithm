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

        def getHasPathSum(node: Optional[TreeNode], sum: int) -> bool:
            if node.left is None and node.right is None:
                return sum == node.val
            else:
                if node.left is not None and getHasPathSum(node.left, sum - node.val):
                    return True
                if node.right is not None and getHasPathSum(node.right, sum - node.val):
                    return True
                return False
            pass

        return getHasPathSum(root, targetSum)

    pass

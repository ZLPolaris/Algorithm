# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    count = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0

        def LRM(node: Optional[TreeNode], num: int):
            if node.left is None and node.right is None:
                self.count += num * 10 + node.val
                return
            num = num * 10 + node.val
            print(num)
            if node.left:
                LRM(node.left, num)
                pass
            if node.right:
                LRM(node.right, num)
                pass
            pass
        LRM(root, 0)
        return self.count

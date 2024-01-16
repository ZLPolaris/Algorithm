import sys
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass

    pass


class Solution:
    first = True
    base = -1
    res = sys.maxsize

    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        def LMR(node: Optional[TreeNode]):
            if node:
                LMR(node.left)
                if self.first:
                    self.base = node.val
                    self.first = False
                    pass
                else:
                    self.res = min(self.res, node.val - self.base)
                    self.base = node.val
                    pass
                LMR(node.right)
                pass
            pass
        LMR(root)
        return self.res
